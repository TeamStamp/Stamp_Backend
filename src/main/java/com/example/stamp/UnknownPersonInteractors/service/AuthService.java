package com.example.stamp.UnknownPersonInteractors.service;

import com.example.stamp.Entities.Usr;
import com.example.stamp.UnknownPersonInteractors.dto.RequestAuth;
import com.example.stamp.UnknownPersonInteractors.dto.ResponseAuth;
import com.example.stamp.UnknownPersonInteractors.repository.AuthRepository;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import com.example.stamp.UnknownPersonInteractors.security.role.Role;
import com.example.stamp.UnknownPersonInteractors.util.SHA256Util;
import com.example.stamp.UnknownPersonInteractors.exception.error.LoginFailedException;
import com.example.stamp.UnknownPersonInteractors.exception.error.NotFoundUserException;
import com.example.stamp.UnknownPersonInteractors.exception.error.RegisterFailedException;
import com.example.stamp.imgTest.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthServiceInterface{

    private final AuthRepository authRepository;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final S3Service s3Service;

    //private final S3Service s3Service; // aws

    @Transactional
    @Override
    public void register(RequestAuth.register registerDto) {
        Usr user = authRepository.findByEmail(registerDto.getEmail());
        if(user != null){
            throw new RegisterFailedException();
        }

        user = authRepository.findByNickname(registerDto.getNickname());
        if(user != null){
            throw new RegisterFailedException();
        }

        String salt = SHA256Util.generateSalt();

        String encryptedPassword = SHA256Util.getEncrypt(registerDto.getPassword(),salt);

        user = Usr.builder()
                .email(registerDto.getEmail())
                .password(encryptedPassword)
                .nickname(registerDto.getNickname())
                .salt(salt)
                .stamp(0L)
                .build();
        authRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<ResponseAuth.login> login(RequestAuth.login loginDto) {
        Usr user = authRepository.findByEmail(loginDto.getEmail());
        if(user == null)
            throw new LoginFailedException();

        String salt = user.getSalt();
        user = authRepository.findByEmailAndPassword(loginDto.getEmail(),SHA256Util.getEncrypt(loginDto.getPassword(),salt));
        if(user == null)
            throw new LoginFailedException();

        ResponseAuth.login login = ResponseAuth.login.builder()
                .accessToken(createAccessToken(user.getEmail()))
                .build();

        return Optional.ofNullable(login);
    }

    @Override
    public String createAccessToken(String userid) {
        Date expiredDate = Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
        JwtAuthToken accessToken = jwtAuthTokenProvider.createAuthToken(userid, Role.USER.getCode(),expiredDate);
        return accessToken.getToken();
    }

    @Override
    @Transactional
    public void update(String email, RequestAuth.update updateDto) {
        Usr user = authRepository.findByEmail(email);
        if(user == null)
            throw new NotFoundUserException();
        Usr user1 = authRepository.findByNickname(updateDto.getNickname());
        if(user1 != null && !user.equals(user1))
            throw new RegisterFailedException();

        String salt = SHA256Util.generateSalt();
        String encryptedPassword = SHA256Util.getEncrypt(updateDto.getPassword(), salt);
        user.update(encryptedPassword,updateDto.getNickname(),salt);
    }

    @Override
    @Transactional
    public ResponseAuth.info getUserInfo(String email) {
        Usr user = authRepository.findByEmail(email);
        if (user == null)
            throw new NotFoundUserException();
        ResponseAuth.info response = ResponseAuth.info.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .stamp(user.getStamp())
                .imgUrl(user.getImgUrl())
                .build();
        return response;
    }

    @Override
    @Transactional
    public List<ResponseAuth.rank> getRankInfo(){
        List<Usr> usrList = authRepository.findAll(Sort.by(Sort.Direction.DESC, "stamp"));
        List<ResponseAuth.rank> rankList = new ArrayList<>();
        usrList.stream().forEach(usr -> rankList.add(ResponseAuth.rank.toDto(usr)));
        return rankList;
    }

    @Override
    @Transactional
    public void uploadImg(String email, MultipartFile file){
        Usr user = authRepository.findByEmail(email);
        String url = "";
        try {
            url = s3Service.upload(file,"task");
        }
        catch (IOException e){
            System.out.println("S3 upload failed.");
        }
        user.setImgUrl(url);
        authRepository.save(user);
    }

}

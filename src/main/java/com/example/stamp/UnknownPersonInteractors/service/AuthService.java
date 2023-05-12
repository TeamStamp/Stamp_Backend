package com.example.stamp.UnknownPersonInteractors.service;

import com.example.stamp.Entities.UserEntity;
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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements AuthServiceInterface{

    private final AuthRepository authRepository;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;

    //private final S3Service s3Service; // aws

    @Transactional
    @Override
    public void register(RequestAuth.register registerDto) {
        UserEntity user = authRepository.findByEmail(registerDto.getEmail());
        if(user != null){
            throw new RegisterFailedException();
        }

        user = authRepository.findByNickname(registerDto.getNickname());
        if(user != null){
            throw new RegisterFailedException();
        }

        String salt = SHA256Util.generateSalt();

        String encryptedPassword = SHA256Util.getEncrypt(registerDto.getPassword(),salt);

        user = UserEntity.builder()
                .email(registerDto.getEmail())
                .password(encryptedPassword)
                .nickname(registerDto.getNickname())
                .salt(salt)
                .build();
        authRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<ResponseAuth.login> login(RequestAuth.login loginDto) {
        UserEntity user = authRepository.findByEmail(loginDto.getEmail());
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
        UserEntity user = authRepository.findByEmail(email);
        if(user == null)
            throw new NotFoundUserException();
        UserEntity user1 = authRepository.findByNickname(updateDto.getNickname());
        if(user1 != null && !user.equals(user1))
            throw new RegisterFailedException();

        String salt = SHA256Util.generateSalt();
        String encryptedPassword = SHA256Util.getEncrypt(updateDto.getPassword(), salt);
        user.update(encryptedPassword,updateDto.getNickname(),salt);
    }

    @Override
    @Transactional
    public ResponseAuth.info getUserInfo(String email) {
        UserEntity user = authRepository.findByEmail(email);
        if (user == null)
            throw new NotFoundUserException();
        ResponseAuth.info response = ResponseAuth.info.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .build();
        return response;
    }
}

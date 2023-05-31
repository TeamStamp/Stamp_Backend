package com.example.stamp.CMPlcInteractors;

import com.example.stamp.Entities.Plc;
import com.example.stamp.UnknownPersonInteractors.repository.AuthRepository;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import com.example.stamp.imgTest.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CMPlcServiceImpl implements CMPlcService {

    private final CMPlcRepository CMPlcRepository;

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final AuthRepository authRepository;

    private final S3Service s3Service;

    private String getEmail(Optional<String> token){
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        return email;
    }
    public ResponsePlcDto createPlc(RequestPlcDto.createPlcDto dto, Optional<String> token, MultipartFile multipartFile) throws IOException {
        String imageUrl = s3Service.upload(multipartFile,"Plc");
        return of(CMPlcRepository.save(of(dto,getEmail(token),imageUrl)));

    }

    private com.example.stamp.CMPlcInteractors.ResponsePlcDto of(Plc entity){
        return com.example.stamp.CMPlcInteractors.ResponsePlcDto.builder()
                .id(entity.getId())
                .plcName(entity.getPlcName())
                .lat(entity.getLat())
                .lng(entity.getLng())
                .imgUrl(entity.getImgUrl())
                .category(entity.getCategory())
                .isAccept(entity.getIsAccept()).build();
    }
    private Plc of(RequestPlcDto.createPlcDto dto,String email,String imageUrl) {
        return Plc.builder()
                .plcName(dto.getPlcName())
                .lat(dto.getLat())
                .lng(dto.getLng())
                .imgUrl(imageUrl)
                .category(dto.getCategory())
                .cost(dto.getCost())
                .isAccept(false)
                .usr(authRepository.findByEmail(email))
                .build();
    }

}

package com.example.stamp.CMPlcInteractors;

import com.example.stamp.Entities.Plc;
import com.example.stamp.Entities.Usr;
import com.example.stamp.UnknownPersonInteractors.repository.AuthRepository;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CMPlcServiceImpl implements CMPlcService {

    private final CMPlcRepository CMPlcRepository;

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final AuthRepository authRepository;
    private String getEmail(Optional<String> token){
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        return email;
    }
    public void createPlc(RequestPlcDto.createPlcDto dto, Optional<String> token) {

        CMPlcRepository.save(of(dto,getEmail(token)));
    }
    private Plc of(RequestPlcDto.createPlcDto dto,String email) {
        return Plc.builder()
                .plcName(dto.getPlcName())
                .lat(dto.getLat())
                .lng(dto.getLng())
                .imgUrl(dto.getImgUrl())
                .category(dto.getCategory())
                .cost(dto.getCost())
                .isAccept(false)
                .usr(authRepository.findByEmail(email))
                .build();
    }

}

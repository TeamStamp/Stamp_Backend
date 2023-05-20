package com.example.stamp.CMPlcController;

import com.example.stamp.CMPlcInteractors.CMPlcService;
import com.example.stamp.CMPlcInteractors.RequestPlcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CMPlcFacade {
    private final CMPlcService cmPlcService;

    void createPlc(RequestPlcDto.createPlcDto dto, Optional<String> token){
        cmPlcService.createPlc(dto,token);

    }

}

package com.example.stamp.CMPlcController;

import com.example.stamp.CMPlcInteractors.CMPlcService;
import com.example.stamp.CMPlcInteractors.RequestPlcDto;
import com.example.stamp.PlcInteractors.PlcService;
import com.example.stamp.PlcInteractors.ResponsePlcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CMPlcFacade {
    private final CMPlcService cmPlcService;
    private final PlcService plcService;
    void createPlc(RequestPlcDto.createPlcDto dto, Optional<String> token){
        cmPlcService.createPlc(dto,token);

    }
    //장소 검색
    List<ResponsePlcDto> searchPlc(com.example.stamp.PlcInteractors.RequestDto.RequestSearchDto dto){return plcService.searchPlc(dto);}
}

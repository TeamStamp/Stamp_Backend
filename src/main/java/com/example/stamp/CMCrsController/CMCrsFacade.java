package com.example.stamp.CMCrsController;

import com.example.stamp.CMCrsInteractors.CMCrsService;
import com.example.stamp.CMCrsInteractors.RequestDto;
import com.example.stamp.CMCrsInteractors.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CMCrsFacade {

    private final CMCrsService cmCrsService;


    ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto, Optional<String> token){
        return cmCrsService.crsCreate(dto,token);
    }

    void matchDayPlc(RequestDto.matchDayPlcDto dto){cmCrsService.matchDayPlc(dto);}
}

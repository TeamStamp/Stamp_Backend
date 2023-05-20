package com.example.stamp.CMCrsController;

import com.example.stamp.CMCrsInteractors.CMCrsService;
import com.example.stamp.CMCrsInteractors.RequestDto;
import com.example.stamp.CMCrsInteractors.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CMCrsFacade {

    private final CMCrsService cmCrsService;


    ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto){
        return cmCrsService.crsCreate(dto);
    }

    void matchDayPlc(RequestDto.matchDayPlcDto dto){cmCrsService.matchDayPlc(dto);}
}

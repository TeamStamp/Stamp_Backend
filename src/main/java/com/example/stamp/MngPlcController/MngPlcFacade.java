package com.example.stamp.MngPlcController;

import com.example.stamp.MngPlcInteractors.MngPlcService;
import com.example.stamp.MngPlcInteractors.RequestDto;
import com.example.stamp.PlcCmtInteractors.PlcCmtService;
import com.example.stamp.PlcCmtInteractors.RequestPlcCmtDto;
import com.example.stamp.PlcCmtInteractors.ResponsePlcCmtDto;
import com.example.stamp.PlcInteractors.PlcService;
import com.example.stamp.PlcInteractors.RequestPlcDto;
import com.example.stamp.PlcInteractors.ResponsePlcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MngPlcFacade {
    private final MngPlcService mngPlcService;
    private final PlcService plcService;

    private final PlcCmtService plcCmtService;

    void acceptPlc(RequestDto.RequestAcceptDto dto){
        System.out.println("dto:파서드 " + dto.getId());
        mngPlcService.acceptPlc(dto);}


    List<ResponsePlcDto> getAllPlc(){return plcService.getAllPlc();}

    ResponsePlcDto getPlc(RequestPlcDto dto){return plcService.getPlc(dto);}

    void deletePlc(RequestPlcDto dto){ plcService.deletePlc(dto);}

    List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto){ return plcCmtService.getCmt(dto);}

    void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto){plcCmtService.deleteCmt(dto);}

}

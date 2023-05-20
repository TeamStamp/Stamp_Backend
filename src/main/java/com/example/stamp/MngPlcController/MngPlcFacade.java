package com.example.stamp.MngPlcController;

import com.example.stamp.MngPlcInteractors.MngPlcService;
import com.example.stamp.MngPlcInteractors.RequestDto;
import com.example.stamp.MngPlcInteractors.ResponseDto;
import com.example.stamp.PlcCmtInteractors.PlcCmtService;
import com.example.stamp.PlcCmtInteractors.RequestPlcCmtDto;
import com.example.stamp.PlcCmtInteractors.ResponsePlcCmtDto;
import com.example.stamp.PlcInteractors.PlcService;
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

    //모든 장소 조회
    List<ResponsePlcDto> getAllPlc(){return plcService.getAllPlc();}
    //장소조회
    ResponsePlcDto getPlc(com.example.stamp.PlcInteractors.RequestDto.RequestPlcDto dto){return plcService.getPlc(dto);}
    //장소 삭제
    void deletePlc(com.example.stamp.PlcInteractors.RequestDto.RequestPlcDto dto){ plcService.deletePlc(dto);}
    //댓글 조회
    List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto){ return plcCmtService.getCmt(dto);}
    //댓글 삭제
    void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto){plcCmtService.deleteCmt(dto);}

    //장소 검색
   List<ResponsePlcDto> searchPlc(com.example.stamp.PlcInteractors.RequestDto.RequestSearchDto dto){return plcService.searchPlc(dto);}
}

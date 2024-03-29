package com.example.stamp.CMPlcController;

 import com.example.stamp.CMPlcInteractors.CMPlcService;
 import com.example.stamp.CMPlcInteractors.RequestPlcDto;
import com.example.stamp.PlcInteractors.PlcService;
import com.example.stamp.PlcInteractors.RequestDto;
import com.example.stamp.PlcInteractors.ResponsePlcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CMPlcFacade {
    private final CMPlcService cmPlcService;
    private final PlcService plcService;
    com.example.stamp.CMPlcInteractors.ResponsePlcDto createPlc(RequestPlcDto.createPlcDto dto, Optional<String> token, MultipartFile multipartFile) throws IOException {
       return cmPlcService.createPlc(dto,token,multipartFile);

    }
    //장소 검색
    List<ResponsePlcDto> searchPlc(com.example.stamp.PlcInteractors.RequestDto.RequestSearchDto dto){return plcService.searchPlc(dto);}

    List<ResponsePlcDto> index(){return plcService.getAllPlc();}

     ResponsePlcDto getPlc(RequestDto.RequestPlcDto dto){
        return plcService.getPlc(dto);
    }


    void deletePlc(RequestDto.RequestPlcDto dto) throws UnsupportedEncodingException {
        plcService.deletePlc(dto);}



}

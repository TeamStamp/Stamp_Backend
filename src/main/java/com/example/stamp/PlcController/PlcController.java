package com.example.stamp.PlcController;


import com.example.stamp.PlcInteractors.PlcService;
import com.example.stamp.PlcInteractors.RequestDto;

import com.example.stamp.PlcInteractors.ResponsePlcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlcController {

    private final PlcService PlcService;
    //코스 전체 조회
    @GetMapping("/api/places")
    public List<ResponsePlcDto> index(){return PlcService.getAllPlc();}


    @PostMapping("/api/place")
    public ResponsePlcDto getPlc(@RequestBody RequestDto.RequestPlcDto dto){
        return PlcService.getPlc(dto);
    }

    @PostMapping("/api/deletePlc")
    public void deletePlc(@RequestBody RequestDto.RequestPlcDto dto){
        PlcService.deletePlc(dto);}

    @PostMapping("api/search/plc")
    public List<ResponsePlcDto> searchPlc(@RequestBody RequestDto.RequestSearchDto dto){return PlcService.searchPlc(dto);}
}

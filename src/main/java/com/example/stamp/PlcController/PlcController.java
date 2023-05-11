package com.example.stamp.PlcController;


import com.example.stamp.PlcInteractors.PlcService;
import com.example.stamp.PlcInteractors.RequestPlcDto;
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

    private final PlcService PlcLoadService;
    //코스 전체 조회
    @GetMapping("/api/places")
    public List<ResponsePlcDto> index(){return PlcLoadService.getAllPlc();}


    @PostMapping("/api/place")
    public ResponsePlcDto getPlc(@RequestBody RequestPlcDto dto){
        return PlcLoadService.getPlc(dto);
    }

}

package com.example.stamp.PlaceLoadController;


import com.example.stamp.PlaceLoadInteractors.PlcLoadService;
import com.example.stamp.PlaceLoadInteractors.RequestPlcDto;
import com.example.stamp.PlaceLoadInteractors.ResponsePlcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlcLoadController {

    private final PlcLoadService PlcLoadService;
    //코스 전체 조회
    @GetMapping("/api/places")
    public List<ResponsePlcDto> index(){return PlcLoadService.getAllPlc();}


    @PostMapping("/api/course")
    public ResponsePlcDto getPlc(@RequestBody RequestPlcDto dto){
        return PlcLoadService.getPlc(dto);
    }

}

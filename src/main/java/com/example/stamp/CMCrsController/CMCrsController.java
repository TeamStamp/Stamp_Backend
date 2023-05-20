package com.example.stamp.CMCrsController;

import com.example.stamp.CMCrsInteractors.RequestDto;
import com.example.stamp.CMCrsInteractors.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CMCrsController {
    private final CMCrsFacade cmCrsFacade;
    @PostMapping("/api/cmCreate/crs")
    public ResponseDto.CrsCreateDto crsCreate(@RequestBody RequestDto.CrsCreateDto dto){
        return cmCrsFacade.crsCreate(dto);
    }
    @PostMapping("/api/cmMatchPlc/crs")
    void matchDayPlc(@RequestBody RequestDto.matchDayPlcDto dto){cmCrsFacade.matchDayPlc(dto);}
}

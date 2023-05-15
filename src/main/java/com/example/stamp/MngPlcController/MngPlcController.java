package com.example.stamp.MngPlcController;
import com.example.stamp.MngPlcInteractors.RequestDto;
import com.example.stamp.PlcCmtInteractors.RequestPlcCmtDto;
import com.example.stamp.PlcCmtInteractors.ResponsePlcCmtDto;
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
public class MngPlcController {
    private final MngPlcFacade mngPlcFacade;
    @PostMapping("api/accept/mngplc")
    void acceptPlc(@RequestBody RequestDto.RequestAcceptDto dto){
        mngPlcFacade.acceptPlc(dto);
    }
    @GetMapping("/api/mngplaces")
    public List<ResponsePlcDto> getAllPlc(){return mngPlcFacade.getAllPlc();}

    @PostMapping("/api/mngplace")
    public ResponsePlcDto getPlc(@RequestBody RequestPlcDto dto){
        return mngPlcFacade.getPlc(dto);
    }
    @PostMapping("/api/mngdeletePlc")
    public void deletePlc(@RequestBody RequestPlcDto dto){
        mngPlcFacade.deletePlc(dto);}
    @PostMapping("/api/mngplccmt")
    public List<ResponsePlcCmtDto> getCmt(@RequestBody RequestPlcCmtDto.RequestLoadPlcCmtDto dto){
        return mngPlcFacade.getCmt(dto);
    }
    @PostMapping("/api/mngdelete/plccmt")
    public void deleteCmt(@RequestBody RequestPlcCmtDto.RequestDeletePlcCmtDto dto){
        mngPlcFacade.deleteCmt(dto);
    }


}

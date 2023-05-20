package com.example.stamp.MngPlcController;
import com.example.stamp.MngPlcInteractors.RequestDto;
import com.example.stamp.PlcCmtInteractors.RequestPlcCmtDto;
import com.example.stamp.PlcCmtInteractors.ResponsePlcCmtDto;

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
    //장소 전체 조회
    @GetMapping("/api/mng/places")
    public List<ResponsePlcDto> getAllPlc(){return mngPlcFacade.getAllPlc();}
    //장소 개별 조회
    @PostMapping("/api/mng/place")
    public ResponsePlcDto getPlc(@RequestBody com.example.stamp.PlcInteractors.RequestDto.RequestPlcDto dto){
        return mngPlcFacade.getPlc(dto);
    }
    //장소 승인
    @PostMapping("api/mngaccept/plc")
    void acceptPlc(@RequestBody RequestDto.RequestAcceptDto dto){
        mngPlcFacade.acceptPlc(dto);
    }
    //장소 삭제
    @PostMapping("/api/mngdelete/plc")
    public void deletePlc(@RequestBody com.example.stamp.PlcInteractors.RequestDto.RequestPlcDto dto){
        mngPlcFacade.deletePlc(dto);}
    //장소 댓글 보기
    @PostMapping("/api/mng/plccmt")
    public List<ResponsePlcCmtDto> getCmt(@RequestBody RequestPlcCmtDto.RequestLoadPlcCmtDto dto){
        return mngPlcFacade.getCmt(dto);
    }
    //장소 댓글 삭제
    @PostMapping("/api/mngdelete/plccmt")
    public void deleteCmt(@RequestBody RequestPlcCmtDto.RequestDeletePlcCmtDto dto){
        mngPlcFacade.deleteCmt(dto);
    }

    @PostMapping("/api/mngsearch/plc")
    public List<ResponsePlcDto> searchPlc(@RequestBody com.example.stamp.PlcInteractors.RequestDto.RequestSearchDto dto){return mngPlcFacade.searchPlc(dto);}
}

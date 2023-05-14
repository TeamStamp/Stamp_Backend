package com.example.stamp.MngPlcController;


import com.example.stamp.MngPlcInteractors.MngPlcService;
import com.example.stamp.MngPlcInteractors.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MngPlcController {
    private final MngPlcService mngPlcService;
    //코스승인
    @PostMapping("api/accept/mngplc")
    public void acceptPlc(@RequestBody RequestDto.RequestAcceptDto dto){mngPlcService.acceptPlc(dto);}



}

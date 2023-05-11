package com.example.stamp.MngCrsController;

import com.example.stamp.MngCrsInteractors.MngCrsService;
import com.example.stamp.MngCrsInteractors.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MngCrsController {
    private final MngCrsService MngCrsService;
    //코스승인
    @PostMapping("api/accept/mngcrs")
    public void acceptCrs(@RequestBody RequestDto.RequestAcceptDto dto){MngCrsService.acceptCrs(dto);}

    //코스삭제

}

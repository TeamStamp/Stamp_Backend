package com.example.stamp.MngUsrController;


import com.example.stamp.MngUsrInteractors.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public  class MngUsrController {
    private final MngUsrFacade mngUsrFacade;


    @PostMapping("api/accept/mngusr")
    public void acceptUsr(@RequestBody RequestDto.RequestAcceptDto dto){
        mngUsrFacade.acceptUsr(dto);
    }

}

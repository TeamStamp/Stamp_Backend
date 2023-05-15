package com.example.stamp.MngUsrController;


import com.example.stamp.MngUsrInteractors.RequestDto;
import com.example.stamp.MngUsrInteractors.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public  class MngUsrController {
    private final MngUsrFacade mngUsrFacade;


    @PostMapping("api/accept/mngusr")
    public void acceptUsr(@RequestBody RequestDto.RequestAcceptDto dto){
        mngUsrFacade.acceptUsr(dto);
    }

    @GetMapping("api/mng/usrload")
    public List<ResponseDto.UsrDto> getUsr(){return mngUsrFacade.getUsr();}
}

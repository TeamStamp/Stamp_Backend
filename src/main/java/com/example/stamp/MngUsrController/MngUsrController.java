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
    //사용자 조회
    @GetMapping("api/mngload/usr")
    public List<ResponseDto.UsrDto> getUsr(){return mngUsrFacade.getUsr();}
   //관리자 권한 부여
    @PostMapping("api/mngaccept/usr")
    public void acceptUsr(@RequestBody RequestDto.RequestAcceptDto dto){
        mngUsrFacade.acceptUsr(dto);
    }
    //사용자 삭제
    @PostMapping("api/mngdelete/usr")
    public void deleteUsr(@RequestBody RequestDto.RequestDeleteDto dto){mngUsrFacade.deleteUsr(dto);}
    //사용자 검색
    @PostMapping("api/mngsearch/usr")
    public List<ResponseDto.UsrDto> searchUsr(@RequestBody RequestDto.RequestSearchDto dto){return mngUsrFacade.searchUsr(dto);}
}

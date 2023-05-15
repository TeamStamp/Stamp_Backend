package com.example.stamp.MngUsrController;



import com.example.stamp.MngUsrInteractors.MngUsrService;

import com.example.stamp.MngUsrInteractors.RequestDto;
import com.example.stamp.MngUsrInteractors.ResponseDto;
import com.example.stamp.UnknownPersonInteractors.service.AuthServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MngUsrFacade {
    private final MngUsrService mngUsrService;
    private final AuthServiceInterface UsrService;
    //관리자 권한 부여
    void acceptUsr(RequestDto.RequestAcceptDto dto){mngUsrService.acceptUsr(dto);}
    //전체 회원 리스트 조회
    List<ResponseDto.UsrDto> getUsr(){return mngUsrService.getUsr();}
    //사용자 삭제
    void deleteUsr(RequestDto.RequestDeleteDto dto){mngUsrService.deleteUsr(dto);}
}

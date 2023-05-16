package com.example.stamp.MngUsrInteractors;

import java.util.List;

public interface MngUsrService {
    //코스 승인
    void acceptUsr(RequestDto.RequestAcceptDto dto);

    List<ResponseDto.UsrDto> getUsr();

    void deleteUsr(RequestDto.RequestDeleteDto dto);

    List<ResponseDto.UsrDto> searchUsr(RequestDto.RequestSearchDto dto);
}

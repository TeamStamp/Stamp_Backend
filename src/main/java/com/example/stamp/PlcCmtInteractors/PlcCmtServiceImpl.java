package com.example.stamp.PlcCmtInteractors;




import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlcCmtServiceImpl implements PlcCmtService{
    private final PlcCmtRepository repository;

    //장소별 댓글 조회
    @Transactional(readOnly = true)
    public List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto dto){
        List<ResponsePlcCmtDto> list = new ArrayList<>();
        repository.findByPlcId(dto.getPlcId()).stream().forEach(PlcCmt -> list.add(ResponsePlcCmtDto.of(PlcCmt)));
        return list;}

    //댓글 작성
    public ResponsePlcCmtDto setCmt(RequestSetPlcCmtDto dto){
        return ResponsePlcCmtDto.of(repository.save(dto.of()));
    }

    //댓글 수정
    public ResponsePlcCmtDto updateCmt(){
        // 댓글 ID를 이용하여 댓글 조회
        // 댓글 내용 업데이트
        // 업데이트된 댓글 저장 및 ResponsePlcCmtDto로 변환하여 반환
        return null;
    }
    //댓글 삭제

    public ResponsePlcCmtDto deleteCmt(){
        // 댓글 ID를 이용하여 댓글 조회
        // 댓글 삭제
        // 삭제된 댓글 정보를 ResponsePlcCmtDto로 변환하여 반환
        return null;
    }
}

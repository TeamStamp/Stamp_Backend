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
    public List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto){
        List<ResponsePlcCmtDto> list = new ArrayList<>();
        repository.findByPlcId(dto.getPlcId()).stream().forEach(PlcCmt -> list.add(ResponsePlcCmtDto.of(PlcCmt)));
        return list;}

    //댓글 작성
    public ResponsePlcCmtDto setCmt(RequestPlcCmtDto.RequestPostPlcCmtDto dto){
         ResponsePlcCmtDto.of(repository.save(dto.of()));
        return null;
    }

    //댓글 수정
    //댓글의 아이디와 수정할 컨텐츠를 매개변수(dto 타입)으로 받아옴
    //엔티티에서 아이디로 조회하여 타겟을 만들어 저장함
    //그 타겟에 컨텐츠를 매개변수로 받아온 컨텐츠로 바꾸고  save함

    @Transactional
    public void updateCmt(RequestPlcCmtDto.RequestUpdatePlcCmtDto dto){
        // 댓글의 아이디와 수정할 컨텐츠를 매개변수(dto 타입)으로 받아옴
        ResponsePlcCmtDto target = ResponsePlcCmtDto.off(repository.findById(dto.getId()));
        // 엔티티에서 아이디로 조회하여 타겟을 만들어 저장함
        target.setContent(dto.getContent());
        //그 타겟에 컨텐츠를 매개변수로 받아온 컨텐츠로 바꾸고  save함
        repository.updateContentById(target.getId(), target.getContent());

    }
    //댓글 삭제
    @Transactional
    public void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto){

        // dto에서 받아온 아이디로 찾아서 전체 엔티티와대응하는 Dto에저장
        ResponsePlcCmtDto target = ResponsePlcCmtDto.off(repository.findById(dto.getId()));
        //해당 dto를 엔티티로 변환 후 delete
        repository.deleteAllByid(target.getId());

    }
}

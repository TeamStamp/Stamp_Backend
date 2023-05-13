package com.example.stamp.PlcCmtInteractors;


import com.example.stamp.Entities.PlcCmt;
import com.example.stamp.Entities.PlcEntity;
import com.example.stamp.Entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlcCmtServiceImpl implements PlcCmtService{
    private final PlcCmtRepository repository;

    //댓글조회
    @Transactional(readOnly = true)
    public List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto) {
        List<PlcCmt> entityList = repository.findByPlcId(dto.getPlc());
        List<ResponsePlcCmtDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
    private ResponsePlcCmtDto of(PlcCmt entity) {
        return ResponsePlcCmtDto.builder()
                .id(entity.getId())
                .usr(entity.getUsr().getId())
                .content(entity.getContent())
                .build();
    }


    //댓글 작성
    public void setCmt(RequestPlcCmtDto.RequestSetPlcCmtDto dto){
        repository.save(of(dto));
    }
    private PlcCmt of(RequestPlcCmtDto.RequestSetPlcCmtDto dto) {
        return PlcCmt.builder()
                .usr(UserEntity.builder().id(dto.getUsr()).build())
                .plc(PlcEntity.builder().id(dto.getPlc()).build())
                .content(dto.getContent())
                .build();
    }

    //댓글 수정


    @Transactional
    public void updateCmt(RequestPlcCmtDto.RequestUpdatePlcCmtDto dto){


        PlcCmt target = repository.findById(dto.getId()).get();
        target.setContent(dto.getContent());
        repository.updateContentById(target.getId(), target.getContent());

    }
    //댓글 삭제
    @Transactional
    public void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto){

        PlcCmt target = repository.findById(dto.getId()).get();
        repository.deleteAllByid(target.getId());

    }
}

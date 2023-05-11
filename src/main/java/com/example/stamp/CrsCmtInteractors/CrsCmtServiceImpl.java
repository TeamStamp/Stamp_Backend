package com.example.stamp.CrsCmtInteractors;
import com.example.stamp.Entities.CrsCmt;
import com.example.stamp.Entities.CrsEntity;
import com.example.stamp.Entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrsCmtServiceImpl implements CrsCmtService {
    private final CrsCmtRepository repository;

    //댓글조회
    @Transactional(readOnly = true)
    public List<ResponseCrsCmtDto> getCmt(RequestCrsCmtDto.RequestLoadCrsCmtDto dto) {
        List<CrsCmt> entityList = repository.findByCrsId(dto.getCrsId());
        List<ResponseCrsCmtDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
    private ResponseCrsCmtDto of(CrsCmt entity) {
        return ResponseCrsCmtDto.builder()
                .id(entity.getId())
                .UserId(entity.getUserId().getId())
                .Content(entity.getContent())
                .build();
    }


    //댓글 작성
    public void setCmt(RequestCrsCmtDto.RequestSetCrsCmtDto dto){
         repository.save(of(dto));
    }
    private CrsCmt of(RequestCrsCmtDto.RequestSetCrsCmtDto dto) {
         return CrsCmt.builder()
                        .UserId(UserEntity.builder().id(dto.getUserId()).build())
                        .CrsId(CrsEntity.builder().id(dto.getCrsId()).build())
                        .Content(dto.getContent())
                        .build();
    }

    //댓글 수정
    @Transactional
    public void updateCmt(RequestCrsCmtDto.RequestUpdateCrsCmtDto dto){


        CrsCmt target = repository.findById(dto.getId()).get();
        target.setContent(dto.getContent());
        repository.updateContentById(target.getId(), target.getContent());

    }
    //댓글 삭제
    @Transactional
    public void deleteCmt(RequestCrsCmtDto.RequestDeleteCrsCmtDto dto){

        CrsCmt target = repository.findById(dto.getId()).get();
        repository.deleteAllByid(target.getId());

    }
}

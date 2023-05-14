package com.example.stamp.CrsCmtInteractors;
import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.CrsCmt;
import com.example.stamp.Entities.Usr;
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
        List<CrsCmt> entityList = repository.findByCrsId(dto.getCrs());
        List<ResponseCrsCmtDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
    private ResponseCrsCmtDto of(CrsCmt entity) {
        return ResponseCrsCmtDto.builder()
                .id(entity.getId())
                .usr(entity.getUsr().getId())
                .content(entity.getContent())
                .build();
    }


    //댓글 작성
    public void setCmt(RequestCrsCmtDto.RequestSetCrsCmtDto dto){
         repository.save(of(dto));
    }
    private CrsCmt of(RequestCrsCmtDto.RequestSetCrsCmtDto dto) {
         return CrsCmt.builder()
                        .usr(Usr.builder().id(dto.getUsr()).build())
                        .crs(Crs.builder().id(dto.getCrs()).build())
                        .content(dto.getContent())
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

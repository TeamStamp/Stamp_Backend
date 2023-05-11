package com.example.stamp.CrsLoadInteractors;
import com.example.stamp.Entities.CrsEntity;

import com.example.stamp.Entities.DayEntity;
import com.example.stamp.Entities.DayInPlc;
import com.example.stamp.Entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.PlatformTransactionManager;



@Service
@RequiredArgsConstructor

public class CrsLoadServiceImpl implements CrsLoadService{

    private final CrsRepository repository;
    private final PlatformTransactionManager transactionManager;

    @Transactional(readOnly = true)
    public List<ResponseCrsDto> getAllCrs() {
        List<ResponseCrsDto> list = new ArrayList<>();
        repository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().forEach(crs -> list.add(ResponseCrsDto.of(crs)));
        return list;
    }

    @Transactional(readOnly = true)
    public ResponseOneCrsDto getCrs(RequestCrsDto dto){
        ResponseOneCrsDto Dto = ResponseOneCrsDto.of(repository.findById(dto.getId()).get());
        return Dto;}


    public void deleteCrs(RequestCrsDto dto) {
        Optional<CrsEntity> target = repository.findById(dto.getId());

        if (target.isPresent()) {
            CrsEntity crs = target.get();

            // CrsEntity와 연관된 DayEntity의 참조를 수정하여 삭제
            for (DayEntity day : crs.getDayx()) {
                // DayEntity와 연관된 DayInPlc의 참조를 수정하여 삭제
                for (DayInPlc dayInPlc : day.getPlace()) {
                    dayInPlc.setDayId(null);
                }
                day.getPlace().clear();

                day.setCrsId(null);
            }
            crs.getDayx().clear();

            // CrsEntity와 연관된 UserEntity의 참조를 수정하여 삭제
            if (crs.getUserId() != null) {
                UserEntity user = crs.getUserId();
                user.getCourse().remove(crs);
                crs.setUserId(null);
            }

            // CrsEntity 삭제
            repository.delete(crs);
        }
    }

}

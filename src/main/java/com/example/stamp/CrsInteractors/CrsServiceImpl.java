package com.example.stamp.CrsInteractors;
import com.example.stamp.Entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class CrsServiceImpl implements CrsService {

    private final CrsRepository repository;
// 전체 코스 조회
    @Transactional(readOnly = true)
    public List<ResponseCrsDto.ResponseAllCrsCmtDto> getAllCrs() {
        List<CrsEntity> entityList = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ResponseCrsDto.ResponseAllCrsCmtDto> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
        public static ResponseCrsDto.ResponseAllCrsCmtDto of(CrsEntity entity){
        return ResponseCrsDto.ResponseAllCrsCmtDto.builder()
                .id(entity.getId())
                .CrsName(entity.getCrsName())
                .ImgUrl(entity.getImgUrl())
                .UserId(entity.getUserId().getId())
                .build();
    }

    //개별 코스 조회
    @Transactional(readOnly = true)
    public ResponseCrsDto.ResponseOneCrsDto getCrs(RequestCrsDto dto){
        ResponseCrsDto.ResponseOneCrsDto Dto = on(repository.findById(dto.getId()).get());
        return Dto;}
    public static ResponseCrsDto.ResponseOneCrsDto on (CrsEntity entity){
        return ResponseCrsDto.ResponseOneCrsDto.builder()
                .id(entity.getId())
                .CrsName(entity.getCrsName())
                .ImgUrl(entity.getImgUrl())
                .UserId(entity.getUserId().getId())
                .Dayx(entity.getDayx().stream().map(CrsServiceImpl::on).collect(Collectors.toSet()))
                .build();
    }
    public static ResponseCrsDto.LinkedDayDto on(DayEntity entity){
        return ResponseCrsDto.LinkedDayDto.builder()
                .id(entity.getId())
                .Dayx(entity.getDayx())
                .Plc(entity.getPlace().stream().map(DayInPlc::getPlcId).map(CrsServiceImpl::on).collect(Collectors.toSet()))
                .build();
    }

    public static ResponseCrsDto.LinkedPlcDto on(PlcEntity entity) {

        DayInPlc dayInPlc = entity.getDayInPlcs()
                .stream()
                .filter(day -> day.getPlcId().equals(entity))
                .findFirst()
                .orElse(null);
        return ResponseCrsDto.LinkedPlcDto.builder()
                .id(entity.getId())
                .DateTime(dayInPlc.getDateTime())
                .PlcName(entity.getPlcName())
                .ImgUrl(entity.getImgUrl())
                .Cost(entity.getCost())
                .build();
    }

    //코스 삭제
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

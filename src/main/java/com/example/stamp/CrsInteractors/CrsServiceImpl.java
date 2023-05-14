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
        List<Crs> entityList = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ResponseCrsDto.ResponseAllCrsCmtDto> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
        public static ResponseCrsDto.ResponseAllCrsCmtDto of(Crs entity){
        return ResponseCrsDto.ResponseAllCrsCmtDto.builder()
                .id(entity.getId())
                .crsName(entity.getCrsName())
                .imgUrl(entity.getImgUrl())
                .maker(entity.getUsr().getNickname())
                .build();
    }

    //개별 코스 조회
    @Transactional(readOnly = true)
    public ResponseCrsDto.ResponseOneCrsDto getCrs(RequestCrsDto dto){
        ResponseCrsDto.ResponseOneCrsDto Dto = on(repository.findById(dto.getId()).get());
        return Dto;}
    public static ResponseCrsDto.ResponseOneCrsDto on (Crs entity){
        return ResponseCrsDto.ResponseOneCrsDto.builder()
                .id(entity.getId())
                .crsName(entity.getCrsName())
                .imgUrl(entity.getImgUrl())
                .maker(entity.getUsr().getNickname())
                .days(entity.getDays().stream().map(CrsServiceImpl::on).collect(Collectors.toSet()))
                .build();
    }
    public static ResponseCrsDto.LinkedDayDto on(aDay entity){
        return ResponseCrsDto.LinkedDayDto.builder()
                .id(entity.getId())
                .dayx(entity.getDayx())
                .plc(entity.getPlc().stream().map(DayInPlc::getPlc).map(CrsServiceImpl::on).collect(Collectors.toSet()))
                .build();
    }

    public static ResponseCrsDto.LinkedPlcDto on(Plc entity) {

        DayInPlc dayInPlc = entity.getDayInPlcs()
                .stream()
                .filter(day -> day.getPlc().equals(entity))
                .findFirst()
                .orElse(null);
        return ResponseCrsDto.LinkedPlcDto.builder()
                .id(entity.getId())
                .dateTime(dayInPlc.getDateTime())
                .plcName(entity.getPlcName())
                .imgUrl(entity.getImgUrl())
                .cost(entity.getCost())
                .build();
    }
    @Transactional
    //코스 삭제
    public void deleteCrs(RequestCrsDto dto) {
        Optional<Crs> target = repository.findById(dto.getId());

        if (target.isPresent()) {
            Crs crs = target.get();


            // CrsEntity와 연관된 DayEntity의 참조를 수정하여 삭제
            for (aDay day : crs.getDays()) {
                // DayEntity와 연관된 DayInPlc의 참조를 수정하여 삭제
                for (DayInPlc dayInPlc : day.getPlc()) {
                    dayInPlc.setADay(null);
                }
                day.getPlc().clear();

                day.setCrs(null);
            }
            crs.getDays().clear();
            // CrsEntity와 연관된 CrsCmt의 참조를 수정하여 삭제
            for (CrsCmt crsCmt : crs.getCmt()) {
                crsCmt.setCrs(null);
            }
            crs.getCmt().clear();

            // CrsEntity와 연관된 UserEntity의 참조를 수정하여 삭제
            if (crs.getUsr() != null) {
                Usr user = crs.getUsr();
                user.getCrs().remove(crs);
                crs.setUsr(null);
            }

            // Crs 삭제
            repository.deleteBytarget(crs.getId());


        }
    }

}

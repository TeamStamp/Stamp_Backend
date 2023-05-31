package com.example.stamp.CrsInteractors;
import com.example.stamp.Entities.*;
import com.example.stamp.imgTest.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class CrsServiceImpl implements CrsService {

    private final S3Service s3Service;
    private final CrsRepository repository;
// 전체 코스 조회
    @Transactional(readOnly = true)
    public List<ResponseCrsDto.ResponseAllCrsDto> getAllCrs() {
        List<Crs> entityList = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ResponseCrsDto.ResponseAllCrsDto> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
        public static ResponseCrsDto.ResponseAllCrsDto of(Crs entity){
        return ResponseCrsDto.ResponseAllCrsDto.builder()
                .id(entity.getId())
                .crsName(entity.getCrsName())
                .imgUrl(entity.getImgUrl())
                .maker(entity.getUsr().getNickname())
                .firstDay(entity.getFirstDay())
                .lastDay(entity.getLastDay())
                .period((entity.getLastDay().getTime() - entity.getFirstDay().getTime())/1000/(24*60*60) + 1)
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
                .firstDay(entity.getFirstDay())
                .lastDay(entity.getLastDay())
                .period((entity.getLastDay().getTime() - entity.getFirstDay().getTime())/1000/(24*60*60) + 1)
                .days(entity.getDays().stream().map(CrsServiceImpl::on).collect(Collectors.toList()))
                .build();
    }
    public static ResponseCrsDto.LinkedDayDto on(aDay entity){
        return ResponseCrsDto.LinkedDayDto.builder()
                .id(entity.getId())
                .dayx(entity.getDayx())
                .plc(entity.getPlc().stream().map(DayInPlc::getPlc).map(CrsServiceImpl::on).collect(Collectors.toList()))
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
                .imgUrl(dayInPlc.getImgUrl())
                .cost(entity.getCost())
                .dayInPlcId(dayInPlc.getId())
                .category(entity.getCategory())
                .build();
    }
    @Transactional
    //코스 삭제
    public void deleteCrs(RequestCrsDto dto) throws UnsupportedEncodingException {
        Optional<Crs> target = repository.findById(dto.getId());

        if (target.isPresent()) {
            Crs crs = target.get();


            // CrsEntity와 연관된 aDayEntity의 참조를 수정하여 삭제
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
            //버킷에서 이미지 삭제
            //if(target.get().getImgUrl()!="")
            s3Service.deleteFile(target.get().getImgUrl());
            // Crs 삭제
            repository.deleteBytarget(crs.getId());




        }
    }

}

package com.example.stamp.CMCrsInteractors;
import com.example.stamp.CrsCmtInteractors.RequestCrsCmtDto;
import com.example.stamp.Entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CMCrsServiceImpl implements CMCrsService {

    private final CMCrsRepository repository;
    private final aDayRepository repository2;
    private final dayInPlcRepository repository3;

    //crs, day 동시 생성 day생성 시 day 정보와 코스 정보 입력 안됨, 반환값으로 day의 아이디값 전달
    public ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto) {

        Crs target = repository.save(of(dto));
        Long countDay = dto.getCountDay();
        Long[] days = new Long[countDay.intValue()];
        for(int i =0; i < countDay; i++) {
            aDay aDayEntity = aDay.builder() // builder() 호출
                    .dayx(i + 1)
                    .crs(target)
                    .build(); // build() 호출

            repository2.save(aDayEntity);
            days[i] = aDayEntity.getId();
        }

        ResponseDto.CrsCreateDto Dto = new ResponseDto.CrsCreateDto(target.getId(), days);
        return Dto;
    }

    // dayInPlc 생성해서 장소,day 꼽아 넣기
   public void matchDayPlc(RequestDto.matchDayPlcDto dto){

       repository3.save(of(dto));
   }

    private DayInPlc of(RequestDto.matchDayPlcDto dto) {
        return DayInPlc.builder()
                .plc(Plc.builder().id(dto.getPlc()).build())
                .aDay(aDay.builder().id(dto.getADay()).build())
                .dateTime(dto.getDateTime())
                .build();
    }


    private Crs of(RequestDto.CrsCreateDto dto) {

        return
                Crs.builder()
                        .crsName(dto.getCrsName())
                        .imgUrl(dto.getImgUrl())
                        .usr(Usr.builder().id(dto.getUsr()).build())
                        .build();
    }
}

package com.example.stamp.CMCrsInteractors;
import com.example.stamp.CrsCmtInteractors.RequestCrsCmtDto;
import com.example.stamp.Entities.*;
import com.example.stamp.UnknownPersonInteractors.repository.AuthRepository;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CMCrsServiceImpl implements CMCrsService {

    private final CMCrsRepository repository;
    private final aDayRepository repository2;
    private final dayInPlcRepository repository3;

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final AuthRepository authRepository;

    private String getEmail(Optional<String> token){
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        return email;
    }

    public ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto, Optional<String> token) {

        Crs target = repository.save(of(dto,getEmail(token)));
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


    private Crs of(RequestDto.CrsCreateDto dto,String email) {

        return
                Crs.builder()
                        .crsName(dto.getCrsName())
                        .imgUrl(dto.getImgUrl())
                        .usr(authRepository.findByEmail(email))
                        .build();
    }
}

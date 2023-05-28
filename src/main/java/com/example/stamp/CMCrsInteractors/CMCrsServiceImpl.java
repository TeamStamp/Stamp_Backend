package com.example.stamp.CMCrsInteractors;
import com.example.stamp.Entities.*;
import com.example.stamp.UnknownPersonInteractors.repository.AuthRepository;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import com.example.stamp.imgTest.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CMCrsServiceImpl implements CMCrsService {

    private final CMCrsRepository repository;
    private final aDayRepository repository2;
    private final dayInPlcRepository repository3;

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final AuthRepository authRepository;
    private final S3Service s3Service;
    private String getEmail(Optional<String> token){
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }

        return email;
    }

    public ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto, Optional<String> token,MultipartFile multipartFile) throws IOException {

        String imageUrl = s3Service.upload(multipartFile,"Crs");
        Crs target = repository.save(of(dto,getEmail(token),imageUrl));


        Long period = (target.getLastDay().getTime() - target.getFirstDay().getTime())/1000/(24*60*60) + 1;
        Long[] days = new Long[period.intValue()];
        for(int i =0; i < period; i++) {
            aDay aDayEntity = aDay.builder() // builder() 호출
                    .dayx(i + 1)
                    .crs(target)
                    .build(); // build() 호출

            repository2.save(aDayEntity);
            days[i] = aDayEntity.getId();

        }

        ResponseDto.CrsCreateDto Dto = new ResponseDto.CrsCreateDto(target.getId(), days,target.getFirstDay(),target.getLastDay(),period);
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
                .imgUrl(Plc.builder().id(dto.getPlc()).build().getImgUrl())
                .dateTime(dto.getDateTime())
                .build();
    }


    private Crs of(RequestDto.CrsCreateDto dto,String email,String imageUrl) {

        return
                Crs.builder()
                        .crsName(dto.getCrsName())
                        .imgUrl(imageUrl)
                        .usr(authRepository.findByEmail(email))
                        .firstDay(dto.getFirstDay())
                        .lastDay(dto.getLastDay())
                        .build();
    }


    //등록된 장소 수정
    //토큰에서 추출한 이메일과 사용자의 이메일이 같을 때만

    @Transactional
    public void updateMatch(RequestDto.updateMatchDto dto,MultipartFile multipartFile) throws IOException {

        String imageUrl = s3Service.upload(multipartFile,"Crs");
        repository3.updateImageById(dto.getDayInPlc(),imageUrl);
        repository.updateIsAcceptById(dto.getCrs(),false);

    }
}

package com.example.stamp.CMCrsInteractors;
import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.aDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CMCrsServiceImpl implements CMCrsService {

    private final CMCrsRepository repository;
    private final aDayRepository repository2;
    private final UsrRepository repository3;

    public ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto) {

        Crs target = repository.save(of(dto));
        Long countDay = dto.getCountDay();
        List<ResponseDto.aDayDto> days = new ArrayList<>();
        for(int i = 1; i<=countDay; i++) {
            ResponseDto.aDayDto aDay = new ResponseDto.aDayDto(i);
           aDay aDay1 =new aDay() ;
            aDay1.builder()
                    .dayx(aDay.getDayx())
                    .crs(target)
                    .build();
            repository2.save(aDay1);
            days.add(aDay);

        }

        ResponseDto.CrsCreateDto dto1 = new ResponseDto.CrsCreateDto(target.getId(), days);
        return dto1;
    }


    private Crs of(RequestDto.CrsCreateDto dto) {

        return
                Crs.builder()
                        .crsName(dto.getCrsName())
                        .imgUrl(dto.getImgUrl())
                        .usr(repository3.findById(dto.getUsr()).get())
                        .build();
    }
}

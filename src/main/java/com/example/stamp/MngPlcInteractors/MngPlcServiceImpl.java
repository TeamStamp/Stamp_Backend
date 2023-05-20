package com.example.stamp.MngPlcInteractors;

import com.example.stamp.Entities.Plc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MngPlcServiceImpl implements MngPlcService {
    private final MngPlcRepository repository;

    @Transactional
    public void acceptPlc(RequestDto.RequestAcceptDto dto){
        //장소의 아이디를 매개변수로 받아옴
        System.out.println("dto 서비스: " + dto.getId());
        Plc target = repository.findById(dto.getId()).get();
        boolean x = false ;
        if(target.getIsAccept() == false)
            x = true;
        repository.acceptPlcById(target.getId(), x);
    }

    @Transactional
    public List<ResponseDto.plcSearchDto> searchPlc(RequestDto.RequestSearchDto dto){

        List<Plc> entityList = repository.findPlcByName(dto.getSearch());
        List<ResponseDto.plcSearchDto> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
    private ResponseDto.plcSearchDto of(Plc entity){
        return ResponseDto.plcSearchDto.builder()
                .id(entity.getId())
                .plcName(entity.getPlcName())
                .lat(entity.getLat())
                .lng(entity.getLng())
                .imgUrl(entity.getImgUrl())
                .category(entity.getCategory())
                .cost(entity.getCost())
                .maker(entity.getUsr().getNickname())
                .build();

    }

}

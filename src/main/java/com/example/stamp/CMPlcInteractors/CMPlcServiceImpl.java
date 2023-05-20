package com.example.stamp.CMPlcInteractors;

import com.example.stamp.Entities.Plc;
import com.example.stamp.Entities.Usr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CMPlcServiceImpl implements CMPlcService {

    private final CMPlcRepository CMPlcRepository;


    public void createPlc(RequestPlcDto.createPlcDto dto) {
        CMPlcRepository.save(of(dto));
    }
    private Plc of(RequestPlcDto.createPlcDto dto) {
        return Plc.builder()
                .plcName(dto.getPlcName())
                .lat(dto.getLat())
                .lng(dto.getLng())
                .imgUrl(dto.getImgUrl())
                .category(dto.getCategory())
                .cost(dto.getCost())
                .isAccept(false)
                .usr(Usr.builder().id(dto.getUsr()).build())
                .build();
    }

}

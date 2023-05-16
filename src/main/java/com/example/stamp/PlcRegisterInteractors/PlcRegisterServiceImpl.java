package com.example.stamp.PlcRegisterInteractors;

import com.example.stamp.Entities.Plc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlcRegisterServiceImpl implements PlcRegisterService {

    private final CMPlcRegisterRepository cmPlcRegisterRepository;

    public void createPlc(CMRequestPlcDto.createPlcDto createPlcDto) {
        Plc plcEntity = CMRequestPlcDto.createPlcDto.toEntity(createPlcDto);
        cmPlcRegisterRepository.save(plcEntity);
    }

}

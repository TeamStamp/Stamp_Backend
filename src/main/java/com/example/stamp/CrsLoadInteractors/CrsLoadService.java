package com.example.stamp.CrsLoadInteractors;

import com.example.stamp.CrsLoadController.RequestCrsDto;
import com.example.stamp.DataGateway.entity.CrsEntity;

import java.util.List;

public interface CrsLoadService {

   Long register(RequestCrsDto dto);
    List<ResponseCrsDto> getAllCrs();

    default CrsEntity dtoToEntity(RequestCrsDto dto){

        CrsEntity entity = CrsEntity.builder()
                .id(dto.getId())
                .CrsName(dto.getCrsName())
                .build();
        return entity;
    }
}

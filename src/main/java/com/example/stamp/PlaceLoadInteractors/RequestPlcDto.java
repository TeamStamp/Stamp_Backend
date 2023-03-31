package com.example.stamp.PlaceLoadInteractors;


import com.example.stamp.Entities.PlcEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPlcDto {
    private Long Id;
    public static PlcEntity of(RequestPlcDto dto){
        PlcEntity entity = PlcEntity.builder()
                .Id(dto.getId())
                .build();
        return entity;
    }
}
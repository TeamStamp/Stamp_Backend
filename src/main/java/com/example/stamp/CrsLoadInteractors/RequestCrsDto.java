package com.example.stamp.CrsLoadInteractors;
import com.example.stamp.Entities.CrsEntity;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCrsDto {
    private Long id;
    public static CrsEntity of(RequestCrsDto dto){
        CrsEntity entity = CrsEntity.builder()
                .id(dto.getId())
                .build();
        return entity;
    }
}
package com.example.stamp.CrsLoadInteractors;
import com.example.stamp.Entities.PlcEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkedPlcDto {
    private Long id;
    private String PlcName;
    private String ImgUrl;
    public static LinkedPlcDto of(PlcEntity entity) {
        return LinkedPlcDto.builder()
                .id(entity.getId())
                .PlcName(entity.getPlcName())
                .ImgUrl(entity.getImgUrl())
                .build();
    }
}

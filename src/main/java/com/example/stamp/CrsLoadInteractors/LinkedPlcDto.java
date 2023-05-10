package com.example.stamp.CrsLoadInteractors;
import com.example.stamp.Entities.DayInPlc;
import com.example.stamp.Entities.PlcEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkedPlcDto {
    private Long id;
    private Date DateTime;
    private String PlcName;
    private String ImgUrl;
    public static LinkedPlcDto of(PlcEntity entity) {

        DayInPlc dayInPlc = entity.getDayInPlcs()
                .stream()
                .filter(day -> day.getPlcId().equals(entity))
                .findFirst()
                .orElse(null);
        return LinkedPlcDto.builder()
                .id(entity.getId())
                .DateTime(dayInPlc.getDateTime())
                .PlcName(entity.getPlcName())
                .ImgUrl(entity.getImgUrl())
                .build();
    }
}

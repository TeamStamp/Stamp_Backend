package com.example.stamp.CrsLoadInteractors;
import com.example.stamp.Entities.DayEntity;
import com.example.stamp.Entities.DayInPlc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkedDayDto {
    private Long id;
    private Integer Dayx;
    private Set<LinkedPlcDto> Plc = new HashSet<>();
    public static LinkedDayDto of(DayEntity entity){
        return LinkedDayDto.builder()
                .id(entity.getId())
                .Dayx(entity.getDayx())
                .Plc(entity.getPlace().stream().map(DayInPlc::getPlcId).map(LinkedPlcDto::of).collect(Collectors.toSet()))
                .build();
    }
}

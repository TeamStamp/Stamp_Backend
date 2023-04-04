package com.example.stamp.CrsLoadInteractors;

import com.example.stamp.Entities.CrsEntity;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseOneCrsDto {
    private Long id;
    private String CrsName;
    private String ImgUrl;
    private Long UserId;
    private Set<LinkedDayDto> Dayx = new HashSet<>();
    public static ResponseOneCrsDto of(CrsEntity entity){
        return ResponseOneCrsDto.builder()
                .id(entity.getId())
                .CrsName(entity.getCrsName())
                .ImgUrl(entity.getImgUrl())
                .UserId(entity.getUserId().getId())
                .Dayx(entity.getDayx().stream().map(LinkedDayDto::of).collect(Collectors.toSet()))
                .build();
    }
}
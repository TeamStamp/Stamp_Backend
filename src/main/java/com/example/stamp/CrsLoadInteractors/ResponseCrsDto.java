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

public class ResponseCrsDto {
    private Long id;
    private String CrsName;
    private String ImgUrl;
    private Long UserId;

    public static ResponseCrsDto of(CrsEntity entity){
        return ResponseCrsDto.builder()
                .id(entity.getId())
                .CrsName(entity.getCrsName())
                .ImgUrl(entity.getImgUrl())
                .UserId(entity.getUserId().getId())
                .build();
    }
}
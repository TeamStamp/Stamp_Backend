package com.example.stamp.CrsLoadInteractors;



import com.example.stamp.Entities.CrsEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseCrsDto {
    private Long Id;
    private String CrsName;
    private String CrsMakerToken;
    private String ImageUrl;
    public static ResponseCrsDto of(CrsEntity entity){
        return ResponseCrsDto.builder()
                .Id(entity.getId())
                .CrsName(entity.getCrsName())
                .CrsMakerToken(entity.getCrsMakerToken())
                .ImageUrl(entity.getImageUrl())
                .build();
    }
}
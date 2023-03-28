package com.example.stamp.CrsLoadInteractors;



import com.example.stamp.Entities.CrsEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseCrsDto {
    private Long id;
    private String CrsName;
    private String CrsMakerToken;

    public static ResponseCrsDto of(CrsEntity entity){
        return ResponseCrsDto.builder()
                .id(entity.getId())
                .CrsName(entity.getCrsName())
                .CrsMakerToken(entity.getCrsMakerToken())
                .build();
    }
}
package com.example.stamp.CrsLoadInteractors;



import com.example.stamp.DataGateway.entity.CrsEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCrsDto {
    private Long id;
    private String CrsName;
    private Long CrsMaker;

    public static ResponseCrsDto of(CrsEntity entity){
        return ResponseCrsDto.builder()
                .id(entity.getId())
                .CrsName(entity.getCrsName())
                .build();
    }
}
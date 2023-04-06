package com.example.stamp.PlcCmtInteractors;


import com.example.stamp.Entities.PlcCmt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePlcCmtDto {
    private Long id;
    private Long UserId;
    private String Content;


    public static ResponsePlcCmtDto of(PlcCmt entity){
        return ResponsePlcCmtDto.builder()
                .id(entity.getId())
                .UserId(entity.getUserId().getId())
                .Content(entity.getContent())
                .build();
    }
}

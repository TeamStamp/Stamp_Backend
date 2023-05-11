package com.example.stamp.PlcCmtInteractors;


import com.example.stamp.Entities.PlcCmt;
import com.example.stamp.Entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

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
    protected PlcCmt of(){
        return PlcCmt.builder()
                .UserId(UserEntity.builder().id(this.UserId).build())
                .Content(this.Content)
                .build();
    }
    public static ResponsePlcCmtDto off(Optional<PlcCmt> entity) {
        if (!entity.isPresent()) {
            return null;
        }

        PlcCmt plcCmt = entity.get();
        return ResponsePlcCmtDto.builder()
                .id(plcCmt.getId())
                .UserId(plcCmt.getUserId().getId())
                .Content(plcCmt.getContent())
                .build();
    }
}

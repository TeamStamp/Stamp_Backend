package com.example.stamp.CrsCmtInteractors;


import com.example.stamp.Entities.CrsCmt;
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
public class ResponseCrsCmtDto {
    private Long id;
    private Long UserId;
    private String Content;


    public static ResponseCrsCmtDto of(CrsCmt entity){
        return ResponseCrsCmtDto.builder()
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
    public static ResponseCrsCmtDto off(Optional<CrsCmt> entity) {
        if (!entity.isPresent()) {
            return null;
        }

        CrsCmt crsCmt = entity.get();
        return ResponseCrsCmtDto.builder()
                .id(crsCmt.getId())
                .UserId(crsCmt.getUserId().getId())
                .Content(crsCmt.getContent())
                .build();
    }
}

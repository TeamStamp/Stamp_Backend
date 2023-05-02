package com.example.stamp.CrsCmtInteractors;

import com.example.stamp.Entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestSetCrsCmtDto {

    private Long UserId;
    private Long CrsId;
    private String Content;


    protected CrsCmt of(){
        return CrsCmt.builder()
                .UserId(UserEntity.builder().id(this.UserId).build())
                .CrsId(CrsEntity.builder().id(this.CrsId).build())
                .Content(this.Content)
                .build();
    }


}

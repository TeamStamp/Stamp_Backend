package com.example.stamp.PlcCmtInteractors;

import com.example.stamp.Entities.PlcCmt;
import com.example.stamp.Entities.PlcEntity;
import com.example.stamp.Entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestSetPlcCmtDto {

    private Long UserId;
    private Long PlcId;
    private String Content;


    public PlcCmt of(){
        return PlcCmt.builder()
                .UserId(UserEntity.builder().id(this.UserId).build())
                .PlcId(PlcEntity.builder().id(this.PlcId).build())
                .Content(this.Content)
                .build();
    }
}

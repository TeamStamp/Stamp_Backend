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
public class RequestUpdatePlcCmtDto {


    private Long Id;
    private String Content;


    protected PlcCmt of(){
        return PlcCmt.builder()
                .Content(this.Content)
                .build();
    }
}

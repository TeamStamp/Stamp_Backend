package com.example.stamp.CrsCmtInteractors;

import com.example.stamp.Entities.CrsCmt;
import com.example.stamp.Entities.PlcCmt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUpdateCrsCmtDto {


    private Long Id;
    private String Content;


    protected CrsCmt of(){
        return CrsCmt.builder()
                .Content(this.Content)
                .build();
    }
}

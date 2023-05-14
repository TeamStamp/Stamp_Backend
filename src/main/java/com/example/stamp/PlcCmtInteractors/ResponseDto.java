package com.example.stamp.PlcCmtInteractors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private Long Crs;

    private boolean IsAccept;

}

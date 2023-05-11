package com.example.stamp.PlcCmtInteractors;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ResponsePlcCmtDto {
    private Long id;
    private Long UserId;
    private String Content;


}

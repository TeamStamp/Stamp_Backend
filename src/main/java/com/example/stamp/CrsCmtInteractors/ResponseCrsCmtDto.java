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
@Data
public class ResponseCrsCmtDto {
    private Long id;
    private Long UserId;
    private String Content;
}

package com.example.stamp.PlcRegisterInteractors;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CMResponsePlcDto {
    private Long id;
    private String plcName;
    private String lat;
    private String lng;
    private String imgUrl;
    private String category;
    private Boolean isAccept;
    private Long userId;

    // Generate getters and setters
}

package com.example.stamp.CMPlcInteractors;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ResponsePlcDto {
    private Long id;
    private String plcName;
    private String lat;
    private String lng;
    private String imgUrl;
    private String category;
    private Boolean isAccept;


}

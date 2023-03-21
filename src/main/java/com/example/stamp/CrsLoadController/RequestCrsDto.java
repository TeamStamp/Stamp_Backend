package com.example.stamp.CrsLoadController;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCrsDto {
    private Long id;
    private String CrsName;
    private Long CrsMaker;


}
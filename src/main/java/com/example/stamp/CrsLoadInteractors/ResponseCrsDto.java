package com.example.stamp.CrsLoadInteractors;



import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCrsDto {
    private Long id;
    private String CrsName;
    private Long CrsMaker;


}
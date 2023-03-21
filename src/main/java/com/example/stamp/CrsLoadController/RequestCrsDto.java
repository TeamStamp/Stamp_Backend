package com.example.stamp.CrsLoadController;


import com.example.stamp.DataGateway.entity.CrsEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class RequestCrsDto {
    private Long id;
    private String CourseName;
    private Long CourseMaker;


    public RequestCrsDto(CrsEntity crsEntity) {

        this.id = crsEntity.getId();
        this.CourseName = crsEntity.getCrsName();
        this.CourseMaker = crsEntity.getCrsMaker().getId();
    }


}
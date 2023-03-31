package com.example.stamp.Entities;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;


@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PlcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private  String PlcName;
    @Column
    private  String PlcMakerToken;
    //위도
    @Column
    private String Lat;
    //경도
    @Column
    private String Lng;
    @Column
    private String ImgUrl;
    @Column
    private String Category;
    @Column
    private Boolean IsAccept;

}

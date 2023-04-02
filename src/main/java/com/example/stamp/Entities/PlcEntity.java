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
    private Long id;
    @Column
    private  String PlcName;
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
    @ManyToOne
    @JoinColumn(name = "UserId", nullable = true)
    private UserEntity UserId;

}

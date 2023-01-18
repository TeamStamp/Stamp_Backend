package com.example.stamp.common.entity;


import com.example.stamp.common.dto.PlaceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private  String Placename;
    //위도
    @Column
    private String Lat;
    //경도
    @Column
    private String Lon;

    @OneToMany(mappedBy = "VisitedPlace",orphanRemoval = true)
    private List<VisitedPlaceEntity> visiteduser = new ArrayList<>();

    @OneToMany(mappedBy = "Place",orphanRemoval = true)
    private List<DayEntity> visitedday = new ArrayList<>();

    public static PlaceEntity createPlace(PlaceDto dto,List<VisitedPlaceEntity> visiteduser,List<DayEntity> visitedday) {
        //엔티티 생성 및 반환
        return new PlaceEntity(
                 dto.getId(),
                dto.getPlacename(),
                dto.getLat(),
                dto.getLon(),visiteduser,visitedday);

    }

    //예외처리 하게 되면 사용
//    public void patch(PlaceDto dto) {
//
//        //객체를 갱신
//        if(dto.getPlacename()!=null)
//            this.Placename = dto.getPlacename();
//        if(dto.getLat()!=null)
//            this.Lat = dto.getLat();
//        if(dto.getLon()!=null)
//            this.Lon = dto.getLon();
//
//    }
}

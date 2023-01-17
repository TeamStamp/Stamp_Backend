package com.example.stamp.common.entity;

import com.example.stamp.common.dto.VisitedPlaceDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class VisitedPlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Long VisitorId;

    @Column
    private Long PlaceId;

    public static VisitedPlaceEntity createVisitedPlace(VisitedPlaceDto dto) {
        //엔티티 생성 및 반환
        return new VisitedPlaceEntity(
                dto.getId(),
                dto.getVisitorId(),
                dto.getPlaceId());
    }
}

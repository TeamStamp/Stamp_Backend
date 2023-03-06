package com.example.stamp.DataGateway;

import com.example.stamp.PlaceLoadController.VisitedPlaceDto;
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

    @ManyToOne
    @JoinColumn(name = "VisitorId")
    private UserEntity Visitor;
    public void changeUserEntity(UserEntity Visitor){
        this.Visitor = Visitor;
        Visitor.getVisitedcpalces().add(this);
    }
    @ManyToOne
    @JoinColumn(name = "PlaceId")
    private PlaceEntity VisitedPlace;
    public void changePlaceEntity(PlaceEntity VisitedPlace){
        this.VisitedPlace = VisitedPlace;
        VisitedPlace.getVisiteduser().add(this);
    }

    public static VisitedPlaceEntity createVisitedPlace(VisitedPlaceDto dto,UserEntity Visitor,PlaceEntity Place) {
        //엔티티 생성 및 반환
        return new VisitedPlaceEntity(
                dto.getId(),
                Visitor,
                Place);
    }
}

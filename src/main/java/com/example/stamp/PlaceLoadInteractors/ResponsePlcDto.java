package com.example.stamp.PlaceLoadInteractors;



import com.example.stamp.Entities.PlcEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponsePlcDto {
    private Long id;
    private String PlcName;
    private String Lat;
    private String Lng;
    private String ImgUrl;
    private String Category;
    private Long UserId;
    public static ResponsePlcDto of(PlcEntity entity){
        return ResponsePlcDto.builder()
                .id(entity.getId())
                .PlcName(entity.getPlcName())
                .Lat(entity.getLat())
                .Lng(entity.getLng())
                .ImgUrl(entity.getImgUrl())
                .Category(entity.getCategory())
                .UserId(entity.getUserId().getId())
                .build();
    }
}
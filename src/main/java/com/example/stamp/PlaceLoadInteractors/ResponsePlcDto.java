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
    private Long Id;
    private String PlcName;
    private String PlcMakerToken;
    private String Lat;
    private String Lng;
    private String ImgUrl;
    private String Category;
    public static ResponsePlcDto of(PlcEntity entity){
        return ResponsePlcDto.builder()
                .Id(entity.getId())
                .PlcName(entity.getPlcName())
                .PlcMakerToken(entity.getPlcMakerToken())
                .Lat(entity.getLat())
                .Lng(entity.getLng())
                .ImgUrl(entity.getImgUrl())
                .Category(entity.getCategory())
                .build();
    }
}
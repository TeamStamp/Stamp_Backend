package com.example.stamp.UnknownPersonInteractors.dto;


import com.example.stamp.Entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {
    private Long Id;


    public static UserEntity of(UserRequestDto dto){
        UserEntity entity = UserEntity.builder()
                .id(dto.getId())
                .build();
        return entity;
    }
}

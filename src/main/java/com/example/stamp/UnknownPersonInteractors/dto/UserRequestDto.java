package com.example.stamp.UnknownPersonInteractors.dto;


import com.example.stamp.Entities.Usr;
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


    public static Usr of(UserRequestDto dto){
        Usr entity = Usr.builder()
                .id(dto.getId())
                .build();
        return entity;
    }
}

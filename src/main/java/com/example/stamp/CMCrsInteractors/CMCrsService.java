package com.example.stamp.CMCrsInteractors;


import java.util.Optional;

public interface CMCrsService {
    ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto, Optional<String> token);
    void matchDayPlc(RequestDto.matchDayPlcDto dto);
}

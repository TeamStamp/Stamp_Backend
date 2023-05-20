package com.example.stamp.CMCrsInteractors;


public interface CMCrsService {
    ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto);
    void matchDayPlc(RequestDto.matchDayPlcDto dto);
}

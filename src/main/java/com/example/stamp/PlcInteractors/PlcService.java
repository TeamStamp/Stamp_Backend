package com.example.stamp.PlcInteractors;


import java.util.List;

public interface PlcService {


    List<ResponsePlcDto> getAllPlc();

    ResponsePlcDto getPlc(RequestDto.RequestPlcDto dto);

    void deletePlc(RequestDto.RequestPlcDto dto);

    List<ResponsePlcDto> searchPlc(RequestDto.RequestSearchDto dto);
}

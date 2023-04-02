package com.example.stamp.PlaceLoadInteractors;




import java.util.List;

public interface PlcLoadService {


    List<ResponsePlcDto> getAllPlc();

    ResponsePlcDto getPlc(RequestPlcDto dto);
}

package com.example.stamp.PlcInteractors;




import java.util.List;

public interface PlcService {


    List<ResponsePlcDto> getAllPlc();

    ResponsePlcDto getPlc(RequestPlcDto dto);
}

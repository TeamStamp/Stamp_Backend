package com.example.stamp.PlcInteractors;




import com.example.stamp.CrsInteractors.RequestCrsDto;

import java.util.List;

public interface PlcService {


    List<ResponsePlcDto> getAllPlc();

    ResponsePlcDto getPlc(RequestPlcDto dto);

    void deletePlc(RequestPlcDto dto);
}

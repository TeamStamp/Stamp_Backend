package com.example.stamp.PlaceLoadInteractors;


import com.example.stamp.CrsLoadInteractors.RequestCrsDto;
import com.example.stamp.CrsLoadInteractors.ResponseCrsDto;

import java.util.List;

public interface PlcLoadService {


    List<ResponsePlcDto> getAllPlc();

    ResponsePlcDto getPlc(RequestPlcDto dto);
}

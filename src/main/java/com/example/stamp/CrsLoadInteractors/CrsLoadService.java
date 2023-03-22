package com.example.stamp.CrsLoadInteractors;
import com.example.stamp.CrsLoadController.RequestCrsDto;
import java.util.List;

public interface CrsLoadService {

   Long register(RequestCrsDto dto);
    List<ResponseCrsDto> getAllCrs();


}

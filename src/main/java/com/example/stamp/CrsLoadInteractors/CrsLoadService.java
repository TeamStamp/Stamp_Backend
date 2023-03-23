package com.example.stamp.CrsLoadInteractors;


import java.util.List;

public interface CrsLoadService {


    List<ResponseCrsDto> getAllCrs();

    ResponseCrsDto getCrs(RequestCrsDto dto);
}

package com.example.stamp.CrsInteractors;


import java.util.List;

public interface CrsService {


    List<ResponseCrsDto.ResponseAllCrsDto> getAllCrs();

    ResponseCrsDto.ResponseOneCrsDto getCrs(RequestCrsDto dto);

    void deleteCrs(RequestCrsDto dto);
}

package com.example.stamp.CrsInteractors;


import java.io.UnsupportedEncodingException;
import java.util.List;

public interface CrsService {


    List<ResponseCrsDto.ResponseAllCrsDto> getAllCrs();

    ResponseCrsDto.ResponseOneCrsDto getCrs(RequestCrsDto dto);

    void deleteCrs(RequestCrsDto dto) throws UnsupportedEncodingException;
}

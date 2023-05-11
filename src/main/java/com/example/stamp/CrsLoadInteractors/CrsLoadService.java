package com.example.stamp.CrsLoadInteractors;


import java.util.List;

public interface CrsLoadService {


    List<ResponseCrsDto> getAllCrs();

    ResponseOneCrsDto getCrs(RequestCrsDto dto);

    void deleteCrs(RequestCrsDto dto);
}

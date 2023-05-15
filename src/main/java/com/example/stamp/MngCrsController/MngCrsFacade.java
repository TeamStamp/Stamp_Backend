package com.example.stamp.MngCrsController;

import com.example.stamp.CrsCmtInteractors.CrsCmtService;
import com.example.stamp.CrsCmtInteractors.RequestCrsCmtDto;
import com.example.stamp.CrsCmtInteractors.ResponseCrsCmtDto;
import com.example.stamp.CrsInteractors.CrsService;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.CrsInteractors.ResponseCrsDto;
import com.example.stamp.MngCrsInteractors.MngCrsService;
import com.example.stamp.MngCrsInteractors.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MngCrsFacade {
    private final MngCrsService mngCrsService;
    private final CrsService crsService;

    private final CrsCmtService crsCmtService;

    void acceptCrs(RequestDto.RequestAcceptDto dto){mngCrsService.acceptCrs(dto);}


    List<ResponseCrsDto.ResponseAllCrsDto> getAllCrs(){return crsService.getAllCrs();}

    ResponseCrsDto.ResponseOneCrsDto getCrs(RequestCrsDto dto){return crsService.getCrs(dto);}

    void deleteCrs(RequestCrsDto dto){ crsService.deleteCrs(dto);}

    List<ResponseCrsCmtDto> getCmt(RequestCrsCmtDto.RequestLoadCrsCmtDto dto){ return crsCmtService.getCmt(dto);}

    void deleteCmt(RequestCrsCmtDto.RequestDeleteCrsCmtDto dto){crsCmtService.deleteCmt(dto);}

}

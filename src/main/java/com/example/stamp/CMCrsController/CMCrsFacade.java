package com.example.stamp.CMCrsController;

import com.example.stamp.CMCrsInteractors.CMCrsService;
import com.example.stamp.CMCrsInteractors.RequestDto;
import com.example.stamp.CMCrsInteractors.ResponseDto;
import com.example.stamp.CrsInteractors.CrsService;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.CrsInteractors.ResponseCrsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CMCrsFacade {

    private final CMCrsService cmCrsService;
    private final CrsService CrsService;

    ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto, Optional<String> token, MultipartFile multipartFile) throws IOException {
        return cmCrsService.crsCreate(dto,token,multipartFile);
    }

    void matchDayPlc(RequestDto.matchDayPlcDto dto){cmCrsService.matchDayPlc(dto);}



    //전체 코스 조회
    List<ResponseCrsDto.ResponseAllCrsDto> getAllCrs(){return CrsService.getAllCrs(); }
    //개별 코스 조회
    ResponseCrsDto.ResponseOneCrsDto getCrs(RequestCrsDto dto){return CrsService.getCrs(dto);}
    //코스 삭제
    void deleteCrs(RequestCrsDto dto){CrsService.deleteCrs(dto);}
}

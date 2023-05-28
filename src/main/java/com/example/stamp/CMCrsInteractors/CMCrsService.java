package com.example.stamp.CMCrsInteractors;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface CMCrsService {
    ResponseDto.CrsCreateDto crsCreate(RequestDto.CrsCreateDto dto, Optional<String> token, MultipartFile multipartFile) throws IOException;
    void matchDayPlc(RequestDto.matchDayPlcDto dto);

    void updateMatch(RequestDto.updateMatchDto dto,MultipartFile multipartFile) throws IOException;
}

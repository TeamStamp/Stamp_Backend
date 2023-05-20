package com.example.stamp.CMCrsController;

import com.example.stamp.CMCrsInteractors.RequestDto;
import com.example.stamp.CMCrsInteractors.ResponseDto;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CMCrsController {
    private final CMCrsFacade cmCrsFacade;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    @PostMapping("/api/cmCreate/crs")
    public ResponseDto.CrsCreateDto crsCreate(@RequestBody RequestDto.CrsCreateDto dto, HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        return cmCrsFacade.crsCreate(dto,token);
    }
    @PostMapping("/api/cmMatchPlc/crs")
    void matchDayPlc(@RequestBody RequestDto.matchDayPlcDto dto){cmCrsFacade.matchDayPlc(dto);}
}

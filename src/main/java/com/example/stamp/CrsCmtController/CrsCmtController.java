package com.example.stamp.CrsCmtController;


import com.example.stamp.CrsCmtInteractors.*;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CrsCmtController {
    private final CrsCmtService CrsCmtService;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;


    @PostMapping("/api/crscmt")
    public List<ResponseCrsCmtDto> getCmt(@RequestBody RequestCrsCmtDto.RequestLoadCrsCmtDto dto){
        return CrsCmtService.getCmt(dto);
    }

    @PostMapping("/api/post/crscmt")
    public void setCmt(@RequestBody RequestCrsCmtDto.RequestSetCrsCmtDto dto, HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
       CrsCmtService.setCmt(dto,token);
    }

    @PostMapping("/api/update/crscmt")
    public void updateCmt(@RequestBody RequestCrsCmtDto.RequestUpdateCrsCmtDto dto){

        CrsCmtService.updateCmt(dto);
    }

    @PostMapping("/api/delete/crscmt")
    public void deleteCmt(@RequestBody RequestCrsCmtDto.RequestDeleteCrsCmtDto dto){
        CrsCmtService.deleteCmt(dto);
    }
}

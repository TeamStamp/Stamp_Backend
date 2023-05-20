package com.example.stamp.PlcCmtController;


import com.example.stamp.PlcCmtInteractors.*;
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
public class PlcCmtController {
    private final PlcCmtService PlcCmtService;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    @PostMapping("/api/plccmt")
    public List<ResponsePlcCmtDto> getCmt(@RequestBody RequestPlcCmtDto.RequestLoadPlcCmtDto dto){

        return PlcCmtService.getCmt(dto);
    }

    @PostMapping("/api/post/plccmt")
    public void setCmt(@RequestBody RequestPlcCmtDto.RequestSetPlcCmtDto dto, HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        PlcCmtService.setCmt(dto, token);
    }

    @PostMapping("/api/update/plccmt")
    public void updateCmt(@RequestBody RequestPlcCmtDto.RequestUpdatePlcCmtDto dto){
        PlcCmtService.updateCmt(dto);
    }

    @PostMapping("/api/delete/plccmt")
    public void deleteCmt(@RequestBody RequestPlcCmtDto.RequestDeletePlcCmtDto dto){
        PlcCmtService.deleteCmt(dto);
    }
}

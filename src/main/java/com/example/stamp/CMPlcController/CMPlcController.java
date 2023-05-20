package com.example.stamp.CMPlcController;


import com.example.stamp.CMPlcInteractors.RequestPlcDto;
import com.example.stamp.PlcInteractors.ResponsePlcDto;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor

public class CMPlcController {

    private final CMPlcFacade cmPlcFacade;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    @PostMapping("/api/cmCreate/plc")
    public ResponseEntity createPlc(@RequestBody RequestPlcDto.createPlcDto dto, HttpServletRequest request) {
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        cmPlcFacade.createPlc(dto,token);

        return ResponseEntity.status(HttpStatus.OK).body("ACCESS");
    }
    @PostMapping("/api/cmsearch/plc")
    public List<ResponsePlcDto> searchPlc(@RequestBody com.example.stamp.PlcInteractors.RequestDto.RequestSearchDto dto){return cmPlcFacade.searchPlc(dto);}
}



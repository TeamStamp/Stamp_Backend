package com.example.stamp.PlcRegisterController;


import com.example.stamp.PlcRegisterInteractors.CMRequestPlcDto;
import com.example.stamp.PlcRegisterInteractors.PlcRegisterService;
import com.example.stamp.PlcRegisterInteractors.PlcRegisterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class PlcRegisterController {

    private final PlcRegisterService plcRegisterService;

    @PostMapping("/api/cmCreate/plc")
    public ResponseEntity createPlc(@RequestBody CMRequestPlcDto.createPlcDto createPlcDto) {
        plcRegisterService.createPlc(createPlcDto);

        return ResponseEntity.status(HttpStatus.OK).body("ACCESS");
    }
}



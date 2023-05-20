package com.example.stamp.CMPlcController;


import com.example.stamp.CMPlcInteractors.RequestPlcDto;
import com.example.stamp.CMPlcInteractors.CMPlcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class CMPlcController {

    private final CMPlcService CMPlcService;

    @PostMapping("/api/cmCreate/plc")
    public ResponseEntity createPlc(@RequestBody RequestPlcDto.createPlcDto createPlcDto) {
        CMPlcService.createPlc(createPlcDto);

        return ResponseEntity.status(HttpStatus.OK).body("ACCESS");
    }

}



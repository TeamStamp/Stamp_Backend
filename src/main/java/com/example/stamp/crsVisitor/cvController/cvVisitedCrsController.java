package com.example.stamp.crsVisitor.cvController;

import com.example.stamp.UnknownPersonInteractors.dto.ResponseMessage;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import com.example.stamp.crsVisitor.cvInteractors.ResponseVisitedPlc;
import com.example.stamp.crsVisitor.cvInteractors.cvVisitedPlcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cv/crsVisited")
public class cvVisitedCrsController {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final cvVisitedPlcService cvVisitedPlcService;


    @GetMapping("/{crsId}")
    public ResponseEntity<ResponseMessage> cvGetVPlc(@PathVariable("crsId") Long crsId, HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        List<ResponseVisitedPlc.VPlcListDto> response = cvVisitedPlcService.getVisitedPlc(token, crsId);
        if (!response.isEmpty()) {
            ResponseMessage responseMessage = ResponseMessage.builder()
                    .message("Origin visited course retrieved successfully.")
                    .data(response)
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        }
        else {
            response = cvVisitedPlcService.createVisitedPlc(token, crsId);

            ResponseMessage responseMessage = ResponseMessage.builder()
                    .message("New visited course created successfully.")
                    .data(response)
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMessage);
        }
    }
}

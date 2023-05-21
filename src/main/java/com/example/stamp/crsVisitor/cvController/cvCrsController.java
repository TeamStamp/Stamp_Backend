package com.example.stamp.crsVisitor.cvController;


import com.example.stamp.UnknownPersonInteractors.dto.ResponseMessage;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import com.example.stamp.crsVisitor.cvInteractors.RequestCrs;
import com.example.stamp.crsVisitor.cvInteractors.cvCrsService;
import com.example.stamp.crsVisitor.cvInteractors.ResponseCrs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cv")
public class cvCrsController {

    private final cvCrsService cvCrsService;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;

    @GetMapping("/{crsId}")
    public ResponseEntity<ResponseMessage> cvGetCrs(@PathVariable("crsId") Long crsId, HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        ResponseCrs.cvGetCrsDto response = cvCrsService.getCrs(crsId, token);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .message("Course retrieved successfully.")
                .data(response)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }

    @PutMapping("/visitPlc")
    public ResponseEntity<ResponseMessage> cvVisitPlc(@RequestBody RequestCrs.VisitPlcDto visitPlcDto, HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        cvCrsService.visitPlc(visitPlcDto, token);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .message("Place visited successfully.")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }

    @GetMapping("/getVCrs")
    public ResponseEntity<ResponseMessage> getVCrs(HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        List<ResponseCrs.VCrsListDto> list = cvCrsService.getVCrs(token);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .message("Visited courses retrieved successfully.")
                .data(list)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }
}

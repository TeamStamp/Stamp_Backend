package com.example.stamp.crsVisitor.cvController;


import com.example.stamp.UnknownPersonInteractors.dto.ResponseMessage;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import com.example.stamp.crsVisitor.cvInteractors.cvCrsService;
import com.example.stamp.crsVisitor.cvInteractors.ResponseCrs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cv/crs")
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
}

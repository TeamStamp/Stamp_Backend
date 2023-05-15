package com.example.stamp.crsVisitor.cvController;

import com.example.stamp.UnknownPersonInteractors.dto.ResponseMessage;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import com.example.stamp.crsVisitor.cvInteractors.ResponseVisitedCrs;
import com.example.stamp.crsVisitor.cvInteractors.cvVisitedCrsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cv/crsVisited")
public class cvVisitedCrsController {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final cvVisitedCrsService cvVisitedCrsService;

    @GetMapping("/{crsId}")
    public ResponseEntity<ResponseMessage> cvGetVCrs(@PathVariable("crsId") Long crsId, HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        List<ResponseVisitedCrs.VPlcListDto> response = cvVisitedCrsService.getVisitedCrs(token, crsId);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .message("Visited courses retrieved successfully.")
                .data(response)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }
}

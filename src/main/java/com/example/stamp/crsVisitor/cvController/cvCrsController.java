package com.example.stamp.crsVisitor.cvController;


import com.example.stamp.UnknownPersonInteractors.dto.ResponseMessage;
import com.example.stamp.crsVisitor.cvInteractors.cvCrsService;
import com.example.stamp.crsVisitor.cvInteractors.ResponseCrs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cv/crs")
public class cvCrsController {

    private final cvCrsService cvCrsService;

    @GetMapping("/{crsId}")
    public ResponseEntity<ResponseMessage> cvGetCrs(@PathVariable("crsId") Long crsId){
        ResponseCrs.cvGetCrsDto response = cvCrsService.getCrs(crsId);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .message("Course retrieved successfully.")
                .data(response)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }
}

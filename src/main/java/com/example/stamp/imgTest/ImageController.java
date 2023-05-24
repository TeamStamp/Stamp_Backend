package com.example.stamp.imgTest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    private final S3Service s3Service;



    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestPart MultipartFile file) {

        try {
            String imageUrl = s3Service.upload(file,".");
            return ResponseEntity.ok(imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

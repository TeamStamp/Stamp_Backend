package com.example.stamp.CMPlcInteractors;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface CMPlcService {

    ResponsePlcDto createPlc(RequestPlcDto.createPlcDto createPlcDto, Optional<String> token, MultipartFile multipartFile) throws IOException;

}

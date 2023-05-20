package com.example.stamp.CMPlcInteractors;

import java.util.Optional;

public interface CMPlcService {

    void createPlc(RequestPlcDto.createPlcDto createPlcDto, Optional<String> token);

}

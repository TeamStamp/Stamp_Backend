package com.example.stamp.crsVisitor.cvInteractors;

import java.util.List;
import java.util.Optional;

public interface cvVisitedPlcService {
    public List<ResponseVisitedPlc.VPlcListDto> getVisitedPlc(Optional<String> token, Long crsId);

    public List<ResponseVisitedPlc.VPlcListDto> createVisitedPlc(Optional<String> token, Long crsId);
}

package com.example.stamp.crsVisitor.cvInteractors;

import java.util.List;
import java.util.Optional;

public interface cvVisitedCrsService {
    public List<ResponseVisitedCrs.VPlcListDto> getVisitedCrs(Optional<String> token, Long crsId);
}

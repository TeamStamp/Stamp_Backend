package com.example.stamp.crsVisitor.cvInteractors;

import java.util.Optional;

public interface cvCrsService{
    ResponseCrs.cvGetCrsDto getCrs(Long crsId, Optional<String> token);

    void visitPlc(RequestCrs.VisitPlcDto visitPlcDto, Optional<String> token);
}

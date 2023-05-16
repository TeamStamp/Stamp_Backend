package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.CrsInteractors.CrsRepository;
import com.example.stamp.Entities.*;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class cvCrsServiceImpl implements cvCrsService{

    private final CrsRepository repository;
    private final VisitedPlcRepository vPlcRepository;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;

    @Override
    @Transactional
    public ResponseCrs.cvGetCrsDto getCrs(Long crsId, Optional<String> token) {
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        Optional<Crs> optionalCrs = repository.findById(crsId);
        VisitedPlc vPlc;
        List<VisitedPlc> vPlcList = new ArrayList<>();
        List<ResponseCrs.CrsPlcListDto> plcList = new ArrayList<>();
        Crs crs = null;
        if (optionalCrs.isPresent()) {
            crs = optionalCrs.get();
            for (aDay day : crs.getDays()) {
                for (DayInPlc dayInPlc : day.getPlc()){
                    vPlc = vPlcRepository.findByUsrEmailAndPlcId(email, dayInPlc.getPlc().getId());
                    if (vPlc != null)
                        plcList.add(ResponseCrs.CrsPlcListDto.toDto(dayInPlc.getPlc(), vPlc.isVisited()));
                    else
                        plcList.add(ResponseCrs.CrsPlcListDto.toDto(dayInPlc.getPlc(), false));
                }
            }
        }

        return ResponseCrs.cvGetCrsDto.toDto(crs, plcList);

    }
}

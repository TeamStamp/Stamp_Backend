package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.CrsInteractors.CrsRepository;
import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.DayInPlc;
import com.example.stamp.Entities.VisitedPlc;
import com.example.stamp.Entities.aDay;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class cvVisitedCrsServiceImpl implements cvVisitedCrsService {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final CrsRepository repository;
    private final VisitedPlcRepository vPlcRepository;

    @Override
    public List<ResponseVisitedCrs.VPlcListDto> getVisitedCrs(Optional<String> token, Long crsId) {

        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        Optional<Crs> optionalCrs = repository.findById(crsId);
        VisitedPlc vPlc = null;
        List<VisitedPlc> vPlcList = new ArrayList<>();
        List<ResponseVisitedCrs.VPlcListDto> vPlcListDto = new ArrayList<>();
        Crs crs = null;
        if (optionalCrs.isPresent()) {
            crs = optionalCrs.get();
            for (aDay day : crs.getDays()) {
                for (DayInPlc dayInPlc : day.getPlc()){
                    vPlc = vPlcRepository.findByUsrEmailAndPlcId(email, dayInPlc.getPlc().getId());
                    vPlcListDto.add(ResponseVisitedCrs.VPlcListDto.toDto(vPlc));
                }
            }
        }
//        vPlcList.stream().forEach(a -> vPlcListDto.add(ResponseVisitedCrs.VPlcListDto.toDto(a)));
        return vPlcListDto;
    }
}

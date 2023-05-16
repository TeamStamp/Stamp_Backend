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
public class cvVisitedPlcServiceImpl implements cvVisitedPlcService {

    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final CrsRepository repository;
    private final VisitedPlcRepository vPlcRepository;

    @Override
    public List<ResponseVisitedPlc.VPlcListDto> createVisitedPlc(Optional<String> token, Long crsId) {
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        Optional<Crs> optionalCrs = repository.findById(crsId);
        VisitedPlc vPlc = null;
        List<VisitedPlc> vPlcList = new ArrayList<>();
        List<ResponseVisitedPlc.VPlcListDto> vPlcListDto = new ArrayList<>();
        Crs crs = null;
        if (optionalCrs.isPresent()) {
            crs = optionalCrs.get();
            for (aDay day : crs.getDays()) {
                for (DayInPlc dayInPlc : day.getPlc()){
                    vPlc = RequestVisitedPlc.VPlcRq.toEntity(email, dayInPlc.getPlc().getId());
                    vPlcRepository.save(vPlc);
                    vPlcListDto.add(ResponseVisitedPlc.VPlcListDto.toDto(vPlc));
                }
            }
        }

        return vPlcListDto;
    }

    @Override
    public List<ResponseVisitedPlc.VPlcListDto> getVisitedPlc(Optional<String> token, Long crsId) {

        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        Optional<Crs> optionalCrs = repository.findById(crsId);
        VisitedPlc vPlc = null;
        List<VisitedPlc> vPlcList = new ArrayList<>();
        List<ResponseVisitedPlc.VPlcListDto> vPlcListDto = new ArrayList<>();
        Crs crs = null;
        if (optionalCrs.isPresent()) {
            crs = optionalCrs.get();
            for (aDay day : crs.getDays()) {
                for (DayInPlc dayInPlc : day.getPlc()){
                    vPlc = vPlcRepository.findByUsrEmailAndPlcId(email, dayInPlc.getPlc().getId());
                    vPlcListDto.add(ResponseVisitedPlc.VPlcListDto.toDto(vPlc));
                }
            }
        }
//        vPlcList.stream().forEach(a -> vPlcListDto.add(ResponseVisitedCrs.VPlcListDto.toDto(a)));
        return vPlcListDto;
    }


}

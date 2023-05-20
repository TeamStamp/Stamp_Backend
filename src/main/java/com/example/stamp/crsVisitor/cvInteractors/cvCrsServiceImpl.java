package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.CrsInteractors.CrsRepository;
import com.example.stamp.Entities.*;
import com.example.stamp.UnknownPersonInteractors.repository.AuthRepository;
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
    private final VisitedCrsRepository vCrsRepository;
    private final AuthRepository aRepository;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;

    @Override
    public ResponseCrs.cvGetCrsDto getCrs(Long crsId, Optional<String> token) {
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        Optional<Crs> optionalCrs = repository.findById(crsId);
        VisitedPlc vPlc;
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

    @Override
    public void visitPlc(RequestCrs.VisitPlcDto visitPlcDto, Optional<String> token) {
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        VisitedCrs vCrs = vCrsRepository.findByUsrEmailAndCrsId(email, visitPlcDto.getCrsId());
        if (vCrs == null){
            String crsName = repository.findById(visitPlcDto.getCrsId()).get().getCrsName();
            vCrsRepository.save(RequestCrs.toFirstEntity(email, visitPlcDto.getCrsId(), crsName));
        }
        else{
            vCrs.setCrtStamp(vCrs.getCrtStamp()+1);
            vCrsRepository.save(vCrs);
        }

        VisitedPlc vPlc = vPlcRepository.findByUsrEmailAndPlcId(email, visitPlcDto.getPlcId());

        if (vPlc == null){
            vPlcRepository.save(RequestCrs.toVPlc(visitPlcDto, email));
        }
        else {
            vPlc.setVisited(visitPlcDto.isVisited());
            vPlcRepository.save(vPlc);
        }


        Usr usr = aRepository.findByEmail(email);
        usr.setStamp(usr.getStamp()+1);
        aRepository.save(usr);
    }

    @Override
    public List<ResponseCrs.VCrsListDto> getVCrs(Optional<String> token){
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        List<VisitedCrs> vCrs = vCrsRepository.findAllByUsrEmail(email);
        List<ResponseCrs.VCrsListDto> DtoList = new ArrayList<>();

        vCrs.stream().forEach(VisitedCrs -> DtoList.add(ResponseCrs.VCrsListDto.toDto(VisitedCrs)));

        return DtoList;
    }
}
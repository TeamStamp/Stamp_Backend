package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.CrsInteractors.CrsRepository;
import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.DayInPlc;
import com.example.stamp.Entities.Plc;
import com.example.stamp.Entities.aDay;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class cvCrsServiceImpl implements cvCrsService{

    private final CrsRepository repository;

//    @Override
//    public ResponseCrsDto.ResponseOneCrsDto getCrs(RequestCrsDto dto) {return null;}
//    @Override
//    public List<ResponseCrsDto.ResponseAllCrsCmtDto> getAllCrs() {return null;}
//    @Override
//    public void deleteCrs(RequestCrsDto dto){}

    @Override
    @Transactional
    public ResponseCrs.cvGetCrsDto getCrs(Long crsId) {
        Optional<Crs> optionalCrs = repository.findById(crsId);
        List<ResponseCrs.CrsPlcListDto> plcList = new ArrayList<>();
        Crs crs = null;
        if (optionalCrs.isPresent()) {
            crs = optionalCrs.get();
            for (aDay day : crs.getDays()) {
                for (DayInPlc dayInPlc : day.getPlc()){
                    plcList.add(ResponseCrs.CrsPlcListDto.toDto(dayInPlc.getPlc()));
                }

//                day.getPlc().forEach(dayInPlc -> plcList.add(dayInPlc.getPlc()));
            }
        }


        return ResponseCrs.cvGetCrsDto.toDto(crs, plcList);
    }
}

package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.CrsInteractors.CrsRepository;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.CrsInteractors.ResponseCrsDto;
import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.DayInPlc;
import com.example.stamp.Entities.Plc;
import com.example.stamp.Entities.aDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public cvResponseCrsDto.cvGetCrsDto getCrs(Long crsId) {
        Optional<Crs> optionalCrs = repository.findById(crsId);
        List<cvResponseCrsDto.CrsPlcDto> plcList = new ArrayList<>();
        Crs crs = null;
        if (optionalCrs.isPresent()) {
            crs = optionalCrs.get();
            for (aDay day : crs.getDays()) {
                for (DayInPlc dayInPlc : day.getPlc()){
                    plcList.add(cvResponseCrsDto.CrsPlcDto.toDto(dayInPlc.getPlc()));
                }

//                day.getPlc().forEach(dayInPlc -> plcList.add(dayInPlc.getPlc()));
            }
        }
        return cvResponseCrsDto.cvGetCrsDto.toDto(crs, plcList);
    }
}

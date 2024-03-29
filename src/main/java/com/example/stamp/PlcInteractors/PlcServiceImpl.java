package com.example.stamp.PlcInteractors;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.Entities.*;
import com.example.stamp.MngPlcInteractors.ResponseDto;
import com.example.stamp.imgTest.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class PlcServiceImpl implements PlcService {
    private final S3Service s3Service;
    private final PlcRepository repository;

    private ResponsePlcDto of(Plc entity){
        return ResponsePlcDto.builder()
                .id(entity.getId())
                .plcName(entity.getPlcName())
                .lat(entity.getLat())
                .lng(entity.getLng())
                .imgUrl(entity.getImgUrl())
                .category(entity.getCategory())
                .writer(entity.getUsr().getNickname())
                .cost(entity.getCost())
                .build();
    }

    @Transactional(readOnly = true)
    public List<ResponsePlcDto> getAllPlc() {
        List<Plc> entityList = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ResponsePlcDto> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }

    @Transactional(readOnly = true)
    public ResponsePlcDto getPlc(RequestDto.RequestPlcDto requestDto){
        ResponsePlcDto responseDto = of(repository.findById(requestDto.getId()).get());
        return responseDto;}

    @Transactional
    //장소 삭제
    public void deletePlc(RequestDto.RequestPlcDto dto) throws UnsupportedEncodingException {
        Plc target = repository.findById(dto.getId()).get();


            // PlcEntity와 연관된 dayinPlc의 참조를 수정하여 삭제

            for (DayInPlc dayInPlc : target.getDayInPlcs()) {
                dayInPlc.setPlc(null);

            }

        target.getDayInPlcs().clear();



            // PlcEntity와 연관된 PlcCmt의 참조를 수정하여 삭제
            for (PlcCmt plcCmt : target.getCmt()) {

                plcCmt.setPlc(null);
            }

        target.getCmt().clear();

            // PlcEntity와 연관된 UserEntity의 참조를 수정하여 삭제
            if (target.getUsr() != null) {
                Usr user = target.getUsr();
                user.getCrs().remove(target);
                target.setUsr(null);
            }

        //버킷에서 이미지 삭제
        //if(target.get().getImgUrl()!="")
        s3Service.deleteFile(target.getImgUrl());
            // Plc 삭제
            repository.deleteBytarget(target.getId());



    }
    //장소 검색
    @Transactional
    public List<ResponsePlcDto> searchPlc(RequestDto.RequestSearchDto dto){

        List<Plc> entityList = repository.findPlcByName(dto.getSearch());
        List<ResponsePlcDto> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }

}

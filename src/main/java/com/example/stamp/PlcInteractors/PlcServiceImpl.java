package com.example.stamp.PlcInteractors;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.Entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class PlcServiceImpl implements PlcService {

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
    public ResponsePlcDto getPlc(RequestPlcDto requestDto){
        ResponsePlcDto responseDto = of(repository.findById(requestDto.getId()).get());
        return responseDto;}

    @Transactional
    //장소 삭제
    public void deletePlc(RequestPlcDto dto) {
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

            // Plc 삭제
            repository.deleteBytarget(target.getId());



    }

}

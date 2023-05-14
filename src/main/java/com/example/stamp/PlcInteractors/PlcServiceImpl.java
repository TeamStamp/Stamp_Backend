package com.example.stamp.PlcInteractors;
import com.example.stamp.Entities.Plc;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;


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
                .usr(entity.getUsr().getId())
                .cost(entity.getCost())
                .build();
    }

    @Transactional(readOnly = true)
    public List<ResponsePlcDto> getAllPlc() {
        List<Plc> entityList = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ResponsePlcDto> dtolist = new ArrayList<>();
        entityList.stream().forEach(entity -> dtolist.add(of(entity)));
        return dtolist;
    }

    @Transactional(readOnly = true)
    public ResponsePlcDto getPlc(RequestPlcDto requestDto){
        ResponsePlcDto responseDto = of(repository.findById(requestDto.getId()).get());
        return responseDto;}

}

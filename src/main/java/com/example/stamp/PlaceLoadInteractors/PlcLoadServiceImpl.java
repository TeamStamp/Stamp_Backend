package com.example.stamp.PlaceLoadInteractors;
import com.example.stamp.CrsLoadInteractors.ResponseCrsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor

public class PlcLoadServiceImpl implements PlcLoadService {

    private final PlcRepository repository;

    @Transactional(readOnly = true)
    public List<ResponsePlcDto> getAllPlc() {
        List<ResponsePlcDto> list = new ArrayList<>();
        repository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().forEach(plc -> list.add(ResponsePlcDto.of(plc)));
        return list;
    }

    @Transactional(readOnly = true)
    public ResponsePlcDto getPlc(RequestPlcDto dto){
        ResponsePlcDto Dto = ResponsePlcDto.of(repository.findById(dto.getId()).get());
        return Dto;}

}

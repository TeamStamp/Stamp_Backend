package com.example.stamp.CrsLoadInteractors;

import com.example.stamp.CrsLoadController.RequestCrsDto;
import com.example.stamp.DataGateway.entity.CrsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrsLoadServiceImpl implements CrsLoadService{

    private final CrsRepository repository;

    @Override
    public Long register(RequestCrsDto dto){

        CrsEntity entity = dtoToEntity(dto);
        repository.save(entity);
        return entity.getId();

    }

    @Transactional(readOnly = true)
    public List<ResponseCrsDto> getAllCrs() {
        List<ResponseCrsDto> list = new ArrayList<>();
        List<CrsEntity> Crs = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        Crs.stream().forEach(crs -> list.add(ResponseCrsDto.of(crs)));

        return list;
    }
//
//    public CrsRepository show(Long id) {
//        return CrsRepository.findById(id).orElse(null);
//    }
//
//    public CrsRepository create(Dto dto) {
//        CrsRepository course = dto.toEntity();
//        if(course.getId() != null)
//            return null;
//        return CrsRepository.save(course);
//    }


}

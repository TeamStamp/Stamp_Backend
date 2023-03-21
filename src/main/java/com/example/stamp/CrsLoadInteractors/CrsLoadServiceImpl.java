package com.example.stamp.CrsLoadInteractors;

import com.example.stamp.DataGateway.entity.CrsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrsLoadServiceImpl {
    @Autowired
    private CrsRepository CrsRepository;


    public List<CrsEntity> index() {

        return CrsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
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

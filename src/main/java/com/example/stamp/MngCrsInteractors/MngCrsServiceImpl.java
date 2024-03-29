package com.example.stamp.MngCrsInteractors;

import com.example.stamp.Entities.Crs;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class MngCrsServiceImpl implements MngCrsService {
    private final MngCrsRepository repository;

    @Transactional
    public void acceptCrs(RequestDto.RequestAcceptDto dto){
        //코스의 아이디를 매개변수로 받아옴
        Crs target = repository.findById(dto.getId()).get();
        boolean x = false ;
        if(target.getIsAccept() == false)
            x = true;
        repository.acceptCrsById(target.getId(), x);
    }



}

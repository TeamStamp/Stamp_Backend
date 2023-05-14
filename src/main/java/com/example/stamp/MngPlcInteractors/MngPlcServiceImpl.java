package com.example.stamp.MngPlcInteractors;

import com.example.stamp.Entities.Plc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MngPlcServiceImpl implements MngPlcService {
    private final MngPlcRepository repository;

    @Transactional
    public void acceptPlc(RequestDto.RequestAcceptDto dto){
        //코스의 아이디를 매개변수로 받아옴
        Plc target = repository.findById(dto.getPlc()).get();
        boolean x = false ;
        if(target.getIsAccept() == false)
            x = true;
        repository.acceptPlcById(target.getId(), x);
    }


}
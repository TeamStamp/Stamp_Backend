package com.example.stamp.MngPlcInteractors;

import com.example.stamp.Entities.Plc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MngPlcServiceImpl implements MngPlcService {
    private final MngPlcRepository repository;

    @Transactional
    public void acceptPlc(RequestDto.RequestAcceptDto dto){
        //장소의 아이디를 매개변수로 받아옴
        System.out.println("dto 서비스: " + dto.getId());
        Plc target = repository.findById(dto.getId()).get();
        boolean x = false ;
        if(target.getIsAccept() == false)
            x = true;
        repository.acceptPlcById(target.getId(), x);
    }


}

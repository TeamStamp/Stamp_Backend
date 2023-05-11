package com.example.stamp.MngCrsInteractors;

import com.example.stamp.Entities.CrsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MngCrsServiceImpl implements MngCrsService {
    private final MngCrsRepository repository;

    @Transactional
    public void acceptCrs(RequestDto.RequestAcceptDto dto){
        //코스의 아이디를 매개변수로 받아옴
        Optional<CrsEntity> target = repository.findById(dto.getCrsId());
        boolean x = false ;
        if(target.get().getIsAccept() == false)
            x = true;
        repository.acceptCrsById(target.get().getId(), x);
    }


}

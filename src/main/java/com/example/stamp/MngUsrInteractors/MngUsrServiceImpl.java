package com.example.stamp.MngUsrInteractors;
import com.example.stamp.Entities.Usr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;




@Service
@RequiredArgsConstructor
public class MngUsrServiceImpl implements MngUsrService {
    private final MngUsrRepository repository;

    @Transactional
    public void acceptUsr(RequestDto.RequestAcceptDto dto){
        //코스의 아이디를 매개변수로 받아옴
        Usr target = repository.findById(dto.getId()).get();
        boolean x = false ;
        if(target.getIsAdmin() == false)
            x = true;
        repository.acceptUsrById(target.getId(), x);
    }



}

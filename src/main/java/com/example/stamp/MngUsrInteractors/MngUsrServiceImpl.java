package com.example.stamp.MngUsrInteractors;
import com.example.stamp.Entities.Usr;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


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

    @Transactional
    public List<ResponseDto.UsrDto> getUsr(){
        List<Usr> entityList = repository.findAll();
        List<ResponseDto.UsrDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }


    @Transactional
    public void deleteUsr(RequestDto.RequestDeleteDto dto){

        Usr target = repository.findById(dto.getId()).get();
        repository.delete(target);

    }

    @Transactional
    public List<ResponseDto.UsrDto> searchUsr(RequestDto.RequestSearchDto dto){
        System.out.println("dto"+dto.getSearch());
        List<Usr> entityList = repository.findUsrByName(dto.getSearch());
        List<ResponseDto.UsrDto> dtoList = new ArrayList<>();
        entityList.stream().forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
    private ResponseDto.UsrDto of (Usr entity){
        return ResponseDto.UsrDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .nickname(entity.getNickname())
                .isAdmin(entity.getIsAdmin())
                .imgUrl(entity.getImgUrl()).build();
    }
}

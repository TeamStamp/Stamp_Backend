package com.example.stamp.PlcCmtInteractors;


import com.example.stamp.Entities.PlcCmt;
import com.example.stamp.Entities.Plc;
import com.example.stamp.UnknownPersonInteractors.repository.AuthRepository;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthToken;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlcCmtServiceImpl implements PlcCmtService{
    private final PlcCmtRepository repository;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final AuthRepository authRepository;

    //댓글조회
    @Transactional(readOnly = true)
    public List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto) {
        List<PlcCmt> entityList = repository.findByPlcId(dto.getPlc());
        List<ResponsePlcCmtDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
    private ResponsePlcCmtDto of(PlcCmt entity) {
        return ResponsePlcCmtDto.builder()
                .id(entity.getId())
                .writer(entity.getUsr().getNickname())
                .content(entity.getContent())
                .build();
    }
    private String getEmail(Optional<String> token){
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
             email = jwtAuthToken.getClaims().getSubject();
        }
      return email;
    }

    //댓글 작성
    public void setCmt(RequestPlcCmtDto.RequestSetPlcCmtDto dto, Optional<String> token){
        String email = getEmail(token);
        repository.save(of(dto,email));
    }
    private PlcCmt of(RequestPlcCmtDto.RequestSetPlcCmtDto dto,String email) {
        return PlcCmt.builder()
                .usr(authRepository.findByEmail(email))
                .plc(Plc.builder().id(dto.getPlc()).build())
                .content(dto.getContent())
                .build();
    }

    //댓글 수정
    @Transactional
    public void updateCmt(RequestPlcCmtDto.RequestUpdatePlcCmtDto dto){
        PlcCmt target = repository.findById(dto.getPlc()).get();
        target.setContent(dto.getContent());
        repository.updateContentById(target.getId(), target.getContent());

    }
    //댓글 삭제
    @Transactional
    public void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto){

        PlcCmt target = repository.findById(dto.getId()).get();
        repository.deleteAllByid(target.getId());

    }
}

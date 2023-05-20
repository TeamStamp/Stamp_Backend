package com.example.stamp.CrsCmtInteractors;
import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.CrsCmt;
import com.example.stamp.Entities.Usr;
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
public class CrsCmtServiceImpl implements CrsCmtService {
    private final CrsCmtRepository repository;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    private final AuthRepository authRepository;
    private String getEmail(Optional<String> token){
        String email = null;
        if(token.isPresent()){
            JwtAuthToken jwtAuthToken = jwtAuthTokenProvider.convertAuthToken(token.get());
            email = jwtAuthToken.getClaims().getSubject();
        }
        return email;
    }
    //댓글조회
    @Transactional(readOnly = true)
    public List<ResponseCrsCmtDto> getCmt(RequestCrsCmtDto.RequestLoadCrsCmtDto dto) {
        List<CrsCmt> entityList = repository.findByCrsId(dto.getCrs());
        List<ResponseCrsCmtDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(of(entity)));
        return dtoList;
    }
    private ResponseCrsCmtDto of(CrsCmt entity) {
        return ResponseCrsCmtDto.builder()
                .id(entity.getId())
                .writer(entity.getUsr().getNickname())
                .content(entity.getContent())
                .build();
    }


    //댓글 작성
    public void setCmt(RequestCrsCmtDto.RequestSetCrsCmtDto dto, Optional<String> token){
        String email = getEmail(token);
        repository.save(of(dto,email));
    }
    private CrsCmt of(RequestCrsCmtDto.RequestSetCrsCmtDto dto,String email) {
         return CrsCmt.builder()
                        .usr(authRepository.findByEmail(email))
                        .crs(Crs.builder().id(dto.getCrs()).build())
                        .content(dto.getContent())
                        .build();
    }

    //댓글 수정
    @Transactional
    public void updateCmt(RequestCrsCmtDto.RequestUpdateCrsCmtDto dto){
        CrsCmt target = repository.findById(dto.getId()).get();
        target.setContent(dto.getContent());
        repository.updateContentById(target.getId(), target.getContent());
    }
    //댓글 삭제
    @Transactional
    public void deleteCmt(RequestCrsCmtDto.RequestDeleteCrsCmtDto dto){

        CrsCmt target = repository.findById(dto.getId()).get();
        repository.deleteAllByid(target.getId());

    }
}

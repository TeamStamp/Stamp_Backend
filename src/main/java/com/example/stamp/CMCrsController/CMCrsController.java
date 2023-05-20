package com.example.stamp.CMCrsController;

import com.example.stamp.CMCrsInteractors.RequestDto;
import com.example.stamp.CMCrsInteractors.ResponseDto;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.CrsInteractors.ResponseCrsDto;
import com.example.stamp.UnknownPersonInteractors.security.JwtAuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CMCrsController {
    private final CMCrsFacade cmCrsFacade;
    private final JwtAuthTokenProvider jwtAuthTokenProvider;
    @PostMapping("/api/cmCreate/crs")
    public ResponseDto.CrsCreateDto crsCreate(@RequestBody RequestDto.CrsCreateDto dto,HttpServletRequest request){
        Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        return cmCrsFacade.crsCreate(dto,token);
    }
    @PostMapping("/api/cmMatchPlc/crs")
    void matchDayPlc(@RequestBody RequestDto.matchDayPlcDto dto){cmCrsFacade.matchDayPlc(dto);}


    //is_accpet, is_Admin 과 관련 없이 로그인 한 사람과 코스 제작자가 같으면 수행
    //전체 코스 조회
    @GetMapping("/api/cm/crss")
    public List<ResponseCrsDto.ResponseAllCrsDto> index(){
     //   Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);
        //        if()
//            throw new CmCrsException(HttpStatus.UNAUTHORIZED,"로그인 한 사람만 조회 가능합니다.");

            return cmCrsFacade.getAllCrs();

    }
    //개별 코스 조회
    @PostMapping("/api/cm/crs")
    public ResponseCrsDto.ResponseOneCrsDto getCrs(@RequestBody RequestCrsDto dto){
   //     Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);

        //        if()
//            throw new CmCrsException(HttpStatus.UNAUTHORIZED,"로그인 한 사람만 조회 가능합니다.");
        return cmCrsFacade.getCrs(dto);
    }
    //코스 삭제
    @PostMapping("/api/cmdelete/crs")
    public void deleteCrs(@RequestBody RequestCrsDto dto){
     //   Optional<String> token = jwtAuthTokenProvider.getAuthToken(request);

//        if(token)
//           throw new CmCrsException(HttpStatus.UNAUTHORIZED,"코스를 제작한 사람만 삭제할 수 있습니다.");

        cmCrsFacade.deleteCrs(dto);}
}

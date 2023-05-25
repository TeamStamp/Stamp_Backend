package com.example.stamp.MngCrsController;
import com.example.stamp.CrsCmtInteractors.RequestCrsCmtDto;
import com.example.stamp.CrsCmtInteractors.ResponseCrsCmtDto;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.CrsInteractors.ResponseCrsDto;
import com.example.stamp.MngCrsInteractors.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public  class MngCrsController {
    private final MngCrsFacade mngCrsFacade;
    //코스조회
    @GetMapping("/api/mng/courses")
    public List<ResponseCrsDto.ResponseAllCrsDto> getAllCrs(){return mngCrsFacade.getAllCrs();}

    //코스 개별 조회
    @PostMapping("/api/mng/course")
    public ResponseCrsDto.ResponseOneCrsDto getCrs(@RequestBody RequestCrsDto dto){
        return mngCrsFacade.getCrs(dto);
    }
    //코스 승인
    @PostMapping("api/mngaccept/crs")
    public void acceptCrs(@RequestBody RequestDto.RequestAcceptDto dto){
        mngCrsFacade.acceptCrs(dto);
    }
    //코스 삭제
    @PostMapping("/api/mngdelete/crs")
    public void deleteCrs(@RequestBody RequestCrsDto dto) throws UnsupportedEncodingException {
        mngCrsFacade.deleteCrs(dto);}
    //코스 댓글 조회
    @PostMapping("/api/mng/crscmt")
    public List<ResponseCrsCmtDto> getCmt(@RequestBody RequestCrsCmtDto.RequestLoadCrsCmtDto dto){
        return mngCrsFacade.getCmt(dto);
    }
    //코스 댓글 삭제
    @PostMapping("/api/mngdelete/crscmt")
    public void deleteCmt(@RequestBody RequestCrsCmtDto.RequestDeleteCrsCmtDto dto){
        mngCrsFacade.deleteCmt(dto);
    }

}

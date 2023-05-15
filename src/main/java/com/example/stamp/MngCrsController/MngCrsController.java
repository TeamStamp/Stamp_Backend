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
import java.util.List;


@RestController
@RequiredArgsConstructor
public  class MngCrsController {
    private final MngCrsFacade mngCrsFacade;
    @PostMapping("api/mngaccept/crs")
    public void acceptCrs(@RequestBody RequestDto.RequestAcceptDto dto){
        mngCrsFacade.acceptCrs(dto);
    }
    @GetMapping("/api/mng/courses")
    public List<ResponseCrsDto.ResponseAllCrsDto> getAllCrs(){return mngCrsFacade.getAllCrs();}

    @PostMapping("/api/mng/course")
    public ResponseCrsDto.ResponseOneCrsDto getCrs(@RequestBody RequestCrsDto dto){
        return mngCrsFacade.getCrs(dto);
    }
    @PostMapping("/api/mngdelete/crs")
    public void deleteCrs(@RequestBody RequestCrsDto dto){
        mngCrsFacade.deleteCrs(dto);}
    @PostMapping("/api/mng/crscmt")
    public List<ResponseCrsCmtDto> getCmt(@RequestBody RequestCrsCmtDto.RequestLoadCrsCmtDto dto){
        return mngCrsFacade.getCmt(dto);
    }
    @PostMapping("/api/mngdelete/crscmt")
    public void deleteCmt(@RequestBody RequestCrsCmtDto.RequestDeleteCrsCmtDto dto){
        mngCrsFacade.deleteCmt(dto);
    }

}

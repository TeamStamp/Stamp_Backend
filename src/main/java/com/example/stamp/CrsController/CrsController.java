package com.example.stamp.CrsController;
import com.example.stamp.CrsInteractors.CrsService;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.CrsInteractors.ResponseCrsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrsController {

    private final CrsService CrsLoadService;
    //코스 전체 조회
    @GetMapping("/api/courses")
    public List<ResponseCrsDto.ResponseAllCrsCmtDto> index(){return CrsLoadService.getAllCrs();}


    @PostMapping("/api/course")
    public ResponseCrsDto.ResponseOneCrsDto getCrs(@RequestBody RequestCrsDto dto){
        return CrsLoadService.getCrs(dto);
    }

    @PostMapping("/api/deleteCrs")
    public void deleteCrs(@RequestBody RequestCrsDto dto){CrsLoadService.deleteCrs(dto);};
}

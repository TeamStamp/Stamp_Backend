package com.example.stamp.CrsLoadController;
import com.example.stamp.CrsLoadInteractors.CrsLoadService;
import com.example.stamp.CrsLoadInteractors.RequestCrsDto;
import com.example.stamp.CrsLoadInteractors.ResponseCrsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrsLoadController {

    private final CrsLoadService CrsLoadService;
    //코스 전체 조회
    @GetMapping("/api/courses")
    public List<ResponseCrsDto> index(){return CrsLoadService.getAllCrs();}


    @PostMapping("/api/course")
    public ResponseCrsDto getCrs(@RequestBody RequestCrsDto dto){
        return CrsLoadService.getCrs(dto);
    }

}

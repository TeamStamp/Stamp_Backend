package com.example.stamp.CrsLoadController;



import com.example.stamp.CrsLoadInteractors.CrsLoadService;
import com.example.stamp.CrsLoadInteractors.ResponseCrsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrsLoadController {

    private final CrsLoadService CrsLoadService;

    //코스 전체 조회
    @GetMapping("/api/course")
    public List<ResponseCrsDto> index(){return CrsLoadService.getAllCrs();}


    //코스 개별 조회
//    @GetMapping("/api/course/{id}")
//    public CrsLoadServiceImpl show(@PathVariable Long id){
//        return CrsLoadServiceImpl.show(id);
//    }

}

package com.example.stamp.CrsController;
import com.example.stamp.CrsInteractors.CrsService;
import com.example.stamp.CrsInteractors.RequestCrsDto;
import com.example.stamp.CrsInteractors.ResponseCrsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrsController {

    private final CrsService CrsService;
    //코스 전체 조회
    @GetMapping("/api/courses")
    public List<ResponseCrsDto.ResponseAllCrsDto> index(){return CrsService.getAllCrs();}


    @PostMapping("/api/course")
    public ResponseCrsDto.ResponseOneCrsDto getCrs(@RequestBody RequestCrsDto dto){
        return CrsService.getCrs(dto);
    }

    @PostMapping("/api/deleteCrs")
    public void deleteCrs(@RequestBody RequestCrsDto dto) throws UnsupportedEncodingException {
        CrsService.deleteCrs(dto);}
}

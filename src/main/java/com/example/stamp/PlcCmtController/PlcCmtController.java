package com.example.stamp.PlcCmtController;


import com.example.stamp.PlcCmtInteractors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlcCmtController {
    private final PlcCmtService PlcCmtService;
    @PostMapping("/api/plccmt")
    public List<ResponsePlcCmtDto> getCmt(@RequestBody RequestPlcCmtDto.RequestLoadPlcCmtDto dto){
        return PlcCmtService.getCmt(dto);
    }

    @PostMapping("/api/post/plccmt")
    public void setCmt(@RequestBody RequestPlcCmtDto.RequestSetPlcCmtDto dto){

        PlcCmtService.setCmt(dto);
    }

    @PostMapping("/api/update/plccmt")
    public void updateCmt(@RequestBody RequestPlcCmtDto.RequestUpdatePlcCmtDto dto){
        PlcCmtService.updateCmt(dto);
    }

    @PostMapping("/api/delete/plccmt")
    public void deleteCmt(@RequestBody RequestPlcCmtDto.RequestDeletePlcCmtDto dto){
        PlcCmtService.deleteCmt(dto);
    }
}

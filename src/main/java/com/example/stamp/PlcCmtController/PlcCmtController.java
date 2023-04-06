package com.example.stamp.PlcCmtController;


import com.example.stamp.PlcCmtInteractors.PlcCmtService;
import com.example.stamp.PlcCmtInteractors.RequestPlcCmtDto;
import com.example.stamp.PlcCmtInteractors.RequestSetPlcCmtDto;
import com.example.stamp.PlcCmtInteractors.ResponsePlcCmtDto;
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
    public List<ResponsePlcCmtDto> getCmt(@RequestBody RequestPlcCmtDto dto){
        return PlcCmtService.getCmt(dto);
    }

    @PostMapping("/api/post/plccmt")
    public ResponsePlcCmtDto setCmt(@RequestBody RequestSetPlcCmtDto dto){

        return PlcCmtService.setCmt(dto);
    }
}

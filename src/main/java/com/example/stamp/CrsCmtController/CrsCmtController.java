package com.example.stamp.CrsCmtController;


import com.example.stamp.CrsCmtInteractors.*;
import com.example.stamp.PlcCmtInteractors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrsCmtController {
    private final CrsCmtService CrsCmtService;
    @PostMapping("/api/crscmt")
    public List<ResponseCrsCmtDto> getCmt(@RequestBody RequestCrsCmtDto dto){
        return CrsCmtService.getCmt(dto);
    }

    @PostMapping("/api/post/crscmt")
    public ResponseCrsCmtDto setCmt(@RequestBody RequestSetCrsCmtDto dto){

        return CrsCmtService.setCmt(dto);
    }

    @PostMapping("/api/update/crscmt")
    public void updateCmt(@RequestBody RequestUpdateCrsCmtDto dto){
        CrsCmtService.updateCmt(dto);
    }

    @PostMapping("/api/delete/crscmt")
    public void deleteCmt(@RequestBody RequestDeleteCrsCmtDto dto){
        CrsCmtService.deleteCmt(dto);
    }
}

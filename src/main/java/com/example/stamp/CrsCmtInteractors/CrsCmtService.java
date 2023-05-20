package com.example.stamp.CrsCmtInteractors;



import java.util.List;
import java.util.Optional;

public interface CrsCmtService {

   List<ResponseCrsCmtDto> getCmt(RequestCrsCmtDto.RequestLoadCrsCmtDto dto);

   void setCmt(RequestCrsCmtDto.RequestSetCrsCmtDto dto, Optional<String> token);
   void updateCmt(RequestCrsCmtDto.RequestUpdateCrsCmtDto dto);
   void deleteCmt(RequestCrsCmtDto.RequestDeleteCrsCmtDto dto);
}

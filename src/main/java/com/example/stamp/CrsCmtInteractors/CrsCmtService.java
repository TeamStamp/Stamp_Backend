package com.example.stamp.CrsCmtInteractors;



import java.util.List;

public interface CrsCmtService {

   List<ResponseCrsCmtDto> getCmt(RequestCrsCmtDto.RequestLoadCrsCmtDto dto);

   void setCmt(RequestCrsCmtDto.RequestSetCrsCmtDto dto);
   void updateCmt(RequestCrsCmtDto.RequestUpdateCrsCmtDto dto);
   void deleteCmt(RequestCrsCmtDto.RequestDeleteCrsCmtDto dto);
}

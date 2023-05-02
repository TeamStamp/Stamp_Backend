package com.example.stamp.CrsCmtInteractors;



import java.util.List;

public interface CrsCmtService {

   List<ResponseCrsCmtDto> getCmt(RequestCrsCmtDto dto);

   ResponseCrsCmtDto setCmt(RequestSetCrsCmtDto dto);
   void updateCmt(RequestUpdateCrsCmtDto dto);
   void deleteCmt(RequestDeleteCrsCmtDto dto);
}

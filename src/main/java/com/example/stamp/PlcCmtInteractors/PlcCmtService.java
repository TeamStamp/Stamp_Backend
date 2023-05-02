package com.example.stamp.PlcCmtInteractors;



import java.util.List;

public interface PlcCmtService {

   List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto dto);

   ResponsePlcCmtDto setCmt(RequestSetPlcCmtDto dto);
   void updateCmt(RequestUpdatePlcCmtDto dto);
   void deleteCmt(RequestDeletePlcCmtDto dto);
}

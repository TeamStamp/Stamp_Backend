package com.example.stamp.PlcCmtInteractors;



import java.util.List;

public interface PlcCmtService {

   List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto);

   void setCmt(RequestPlcCmtDto.RequestSetPlcCmtDto dto);
   void updateCmt(RequestPlcCmtDto.RequestUpdatePlcCmtDto dto);
   void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto);
}

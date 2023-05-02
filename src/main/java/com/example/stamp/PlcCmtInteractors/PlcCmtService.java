package com.example.stamp.PlcCmtInteractors;



import java.util.List;

public interface PlcCmtService {

   List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto);

   ResponsePlcCmtDto setCmt(RequestPlcCmtDto.RequestPostPlcCmtDto dto);
   void updateCmt(RequestPlcCmtDto.RequestUpdatePlcCmtDto dto);
   void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto);
}

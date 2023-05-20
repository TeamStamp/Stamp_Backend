package com.example.stamp.PlcCmtInteractors;



import java.util.List;
import java.util.Optional;

public interface PlcCmtService {

   List<ResponsePlcCmtDto> getCmt(RequestPlcCmtDto.RequestLoadPlcCmtDto dto);

   void setCmt(RequestPlcCmtDto.RequestSetPlcCmtDto dto, Optional<String> token);
   void updateCmt(RequestPlcCmtDto.RequestUpdatePlcCmtDto dto);
   void deleteCmt(RequestPlcCmtDto.RequestDeletePlcCmtDto dto);
}

package com.example.stamp.PlcCmtInteractors;

import com.example.stamp.Entities.PlcCmt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlcCmtRepository extends CrudRepository<PlcCmt,Long> {

    @Query(value = "SELECT * FROM  Plc_Cmt WHERE Plc_Id = :PlcId",nativeQuery = true)
    List<PlcCmt> findByPlcId(@Param("PlcId") Long PlcId);

}

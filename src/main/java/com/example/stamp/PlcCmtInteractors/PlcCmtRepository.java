package com.example.stamp.PlcCmtInteractors;

import com.example.stamp.Entities.PlcCmt;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlcCmtRepository extends CrudRepository<PlcCmt,Long> {

    @Query(value = "SELECT * FROM  Plc_Cmt WHERE plc = :plc",nativeQuery = true)
    List<PlcCmt> findByPlcId(@Param("plc") Long plc);


    //UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]

    @Modifying
    @Query(value = "UPDATE Plc_Cmt SET content = :content WHERE id = :id", nativeQuery = true)
    void updateContentById(@Param("id") Long id, @Param("content") String content);

    @Modifying
    @Query(value="DELETE FROM Plc_Cmt WHERE id = :id",nativeQuery = true)
    void deleteAllByid(@Param("id") Long id);
}

package com.example.stamp.CrsCmtInteractors;

import com.example.stamp.Entities.CrsCmt;
import com.example.stamp.Entities.PlcCmt;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrsCmtRepository extends CrudRepository<CrsCmt,Long> {

    @Query(value = "SELECT * FROM  Crs_Cmt WHERE crs = :crs",nativeQuery = true)
    List<CrsCmt> findByCrsId(@Param("crs") Long crs);


    //UPDATE [테이블] SET [열] = '변경할값' WHERE [조건]

    @Modifying
    @Query(value = "UPDATE Crs_Cmt SET content = :content WHERE id = :id", nativeQuery = true)
    void updateContentById(@Param("id") Long id, @Param("content") String content);

    @Modifying
    @Query(value="DELETE FROM Crs_Cmt WHERE id = :id",nativeQuery = true)
    void deleteAllByid(@Param("id") Long id);
}

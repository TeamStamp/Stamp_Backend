package com.example.stamp.CrsInteractors;


import com.example.stamp.Entities.Crs;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CrsRepository extends JpaRepository<Crs,Long> {


   List<Crs> findAll(Sort id);


   @Modifying
   @Query(value="DELETE FROM Crs_Entity WHERE id = :id",nativeQuery = true)
   void deleteBytarget(@Param("id") Long id);

}

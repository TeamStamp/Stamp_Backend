package com.example.stamp.PlcInteractors;


import com.example.stamp.Entities.Plc;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlcRepository extends JpaRepository<Plc,Long> {

   List<Plc> findAll(Sort id);

   @Modifying
   @Query(value="DELETE FROM Plc WHERE id = :id",nativeQuery = true)
   void deleteBytarget(@Param("id") Long id);
}

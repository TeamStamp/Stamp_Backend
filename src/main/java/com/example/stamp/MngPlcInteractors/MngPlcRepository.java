package com.example.stamp.MngPlcInteractors;

import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.Plc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MngPlcRepository extends JpaRepository<Plc,Long> {

    @Modifying
    @Query(value = "UPDATE Plc SET is_Accept = :x WHERE id = :id",nativeQuery = true)
    void acceptPlcById(@Param("id") Long id,@Param("x") boolean x);

}

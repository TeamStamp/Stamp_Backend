package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.DayInPlc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface dayInPlcRepository extends JpaRepository<DayInPlc,Long> {
    @Modifying
    @Query(value = "UPDATE Day_In_Plc SET img_Url = :imgUrl WHERE id = :dayInPlc", nativeQuery = true)
    void updateImageById(@Param("dayInPlc") Long dayInPlc, @Param("imgUrl") String imgUrl);
}

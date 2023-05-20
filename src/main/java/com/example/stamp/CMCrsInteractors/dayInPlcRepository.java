package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.DayInPlc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dayInPlcRepository extends JpaRepository<DayInPlc,Long> {
}

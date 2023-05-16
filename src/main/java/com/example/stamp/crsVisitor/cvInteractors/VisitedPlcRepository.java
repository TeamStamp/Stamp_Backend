package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.Entities.VisitedPlc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface VisitedPlcRepository extends JpaRepository<VisitedPlc, Long> {
    VisitedPlc findByUsrEmailAndPlcId(String userEmail, Long plcId);
}

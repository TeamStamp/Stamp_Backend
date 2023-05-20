package com.example.stamp.crsVisitor.cvInteractors;

import com.example.stamp.Entities.VisitedCrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitedCrsRepository extends JpaRepository<VisitedCrs, Long> {
    VisitedCrs findByUsrEmailAndCrsId(String email, Long crsId);
    List<VisitedCrs> findAllByUsrEmail(String email);
}

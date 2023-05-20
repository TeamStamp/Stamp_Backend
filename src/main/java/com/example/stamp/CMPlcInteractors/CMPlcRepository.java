package com.example.stamp.CMPlcInteractors;
import com.example.stamp.Entities.Plc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CMPlcRepository extends JpaRepository<Plc, Long> {
}

package com.example.stamp.PlcRegisterInteractors;

import com.example.stamp.Entities.Plc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CMPlcRegisterRepository extends JpaRepository<Plc, Long> {
}

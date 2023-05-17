package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.aDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface aDayRepository extends JpaRepository<aDay, Long> {

}

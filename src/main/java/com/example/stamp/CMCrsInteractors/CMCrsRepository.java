package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.Crs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CMCrsRepository extends JpaRepository<Crs, Long> {


}



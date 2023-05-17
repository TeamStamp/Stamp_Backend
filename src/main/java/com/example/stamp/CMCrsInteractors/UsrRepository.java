package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrRepository extends JpaRepository<Usr,Long> {
}

package com.example.stamp.CMCrsInteractors;

import com.example.stamp.Entities.Crs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CMCrsRepository extends JpaRepository<Crs, Long> {

    @Modifying
    @Query(value = "UPDATE Crs SET is_Accept = :isAccept WHERE id = :Crs", nativeQuery = true)
    void updateIsAcceptById(@Param("Crs") Long Crs, @Param("isAccept") boolean isAccept);
}



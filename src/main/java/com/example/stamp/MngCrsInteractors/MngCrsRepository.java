package com.example.stamp.MngCrsInteractors;

import com.example.stamp.Entities.CrsEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MngCrsRepository extends CrudRepository<CrsEntity,Long> {

    @Modifying
    @Query(value = "UPDATE Crs_Entity SET is_Accept = :x WHERE id = :CrsId",nativeQuery = true)
    void acceptCrsById(@Param("CrsId") Long CrsId,@Param("x") boolean x);

}

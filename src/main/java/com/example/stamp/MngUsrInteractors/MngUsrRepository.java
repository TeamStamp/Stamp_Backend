package com.example.stamp.MngUsrInteractors;

import com.example.stamp.Entities.Crs;
import com.example.stamp.Entities.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MngUsrRepository extends JpaRepository<Usr,Long> {

    @Modifying
    @Query(value = "UPDATE Usr SET is_Admin = :x WHERE id = :id",nativeQuery = true)
    void acceptUsrById(@Param("id") Long id,@Param("x") boolean x);

}

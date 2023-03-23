package com.example.stamp.CrsLoadInteractors;


import com.example.stamp.Entities.CrsEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CrsRepository extends CrudRepository<CrsEntity,Long> {


   List<CrsEntity> findAll(Sort id);




}

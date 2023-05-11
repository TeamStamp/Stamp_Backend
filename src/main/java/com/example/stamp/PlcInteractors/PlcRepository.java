package com.example.stamp.PlcInteractors;


import com.example.stamp.Entities.PlcEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlcRepository extends CrudRepository<PlcEntity,Long> {

   List<PlcEntity> findAll(Sort id);


}

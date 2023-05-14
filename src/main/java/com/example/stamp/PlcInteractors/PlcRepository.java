package com.example.stamp.PlcInteractors;


import com.example.stamp.Entities.Plc;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlcRepository extends CrudRepository<Plc,Long> {

   List<Plc> findAll(Sort id);


}

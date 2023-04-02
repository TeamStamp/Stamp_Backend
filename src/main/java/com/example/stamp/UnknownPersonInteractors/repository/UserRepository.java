package com.example.stamp.UnknownPersonInteractors.repository;

import com.example.stamp.Entities.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    List<UserEntity> findAll(Sort id);


}

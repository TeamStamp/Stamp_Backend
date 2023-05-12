package com.example.stamp.UnknownPersonInteractors.repository;

import com.example.stamp.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByNickname(String nickname);
    UserEntity findByEmailAndPassword(String email, String password);
    //Auth findByRefreshToken(String token);
}
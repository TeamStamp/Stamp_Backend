package com.example.stamp.UnknownPersonInteractors.repository;

import com.example.stamp.Entities.Usr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Usr, Long> {
    Usr findByEmail(String email);
    Usr findByNickname(String nickname);
    Usr findByEmailAndPassword(String email, String password);
    //Auth findByRefreshToken(String token);
}
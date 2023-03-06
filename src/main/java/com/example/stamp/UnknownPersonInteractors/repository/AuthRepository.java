package com.example.stamp.UnknownPersonInteractors.repository;

import com.example.stamp.UnknownPersonInteractors.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByEmail(String email);
    Auth findByUsername(String username);
    Auth findByEmailAndPassword(String email, String password);
    //Auth findByRefreshToken(String token);
}
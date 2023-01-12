package com.example.stamp.ReactSpringChatBackEnd.auth.repository;

import com.example.stamp.ReactSpringChatBackEnd.auth.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByEmail(String email);
    Auth findByUsername(String username);
    Auth findByEmailAndPassword(String email, String password);
    //Auth findByRefreshToken(String token);
}
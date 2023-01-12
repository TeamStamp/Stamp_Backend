package com.example.ReactSpringChatBackEnd.auth.security;

public interface AuthToken<T> {
    boolean validate();
    T getClaims();
}

package com.example.stamp.ReactSpringChatBackEnd.auth.security;

public interface AuthToken<T> {
    boolean validate();
    T getClaims();
}

package com.example.stamp.TeamBreak.auth.security;

public interface AuthToken<T> {
    boolean validate();
    T getClaims();
}

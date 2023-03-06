package com.example.stamp.UnknownPersonInteractors.security;

public interface AuthToken<T> {
    boolean validate();
    T getClaims();
}

package com.example.stamp.UnknownPersonInteractors.service;

import com.example.stamp.UnknownPersonInteractors.dto.RequestAuth;
import com.example.stamp.UnknownPersonInteractors.dto.ResponseAuth;

import java.util.List;
import java.util.Optional;

public interface AuthServiceInterface {
    void register(RequestAuth.register registerDto);

    Optional<ResponseAuth.login> login(RequestAuth.login loginDto);

    String createAccessToken(String userid);

    void update(String email, RequestAuth.update updateDto);

    ResponseAuth.info getUserInfo(String email);

    List<ResponseAuth.rank> getRankInfo();

    //String createRefreshToken(String userid);
    //Optional<ResponseAuth.Token> updateAccessToken(String token);
}

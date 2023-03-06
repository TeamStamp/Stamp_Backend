package com.example.stamp.UnknownPersonInteractors.dto;

import lombok.Builder;
import lombok.Data;

public class ResponseAuth {
    @Data
    @Builder
    public static class login{
        private String accessToken;
    }

    @Data
    @Builder
    public static class info{
        private String email;
        private String username;
    }
}

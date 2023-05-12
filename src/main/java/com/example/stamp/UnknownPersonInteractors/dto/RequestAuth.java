package com.example.stamp.UnknownPersonInteractors.dto;

import lombok.Builder;
import lombok.Data;

public class RequestAuth {
    @Builder
    @Data
    public static class register{
        private String Email;
        private String Password;
        private String Nickname;
    }

    @Builder
    @Data
    public static class login{
        private String Email;
        private String Password;
    }

    @Builder
    @Data
    public static class update{
        private String Password;
        private String Nickname;
    }
}

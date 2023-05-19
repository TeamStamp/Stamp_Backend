package com.example.stamp.UnknownPersonInteractors.dto;

import com.example.stamp.Entities.Usr;
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
        private String nickname;
        private Long stamp;
    }

    @Data
    @Builder
    public static class rank{
        private String email;
        private long stamp;

        public static rank toDto(Usr usr){
            return rank.builder()
                    .email(usr.getEmail())
                    .stamp(usr.getStamp())
                    .build();
        }
    }

}

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
        private String imgUrl;
    }

    @Data
    @Builder
    public static class rank{
        private String nickName;
        private String imgUrl;
        private long stamp;

        public static rank toDto(Usr usr){
            return rank.builder()
                    .nickName(usr.getNickname())
                    .imgUrl(usr.getImgUrl())
                    .stamp(usr.getStamp())
                    .build();
        }
    }

}

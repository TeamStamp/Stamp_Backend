package com.example.stamp.MngUsrInteractors;

import lombok.Builder;
import lombok.Data;

public class ResponseDto {
    @Builder
    @Data
    public static class UsrDto{

        private Long id;

        private String nickname;

        private String email;

        private String imgUrl;

        private boolean isAdmin;




    }
}

package com.example.ReactSpringChatBackEnd.chat.dto;

import lombok.Builder;
import lombok.Data;

public class ResponseChat {

    @Builder
    @Data
    public static class test{
        private String nickname;
    }

}

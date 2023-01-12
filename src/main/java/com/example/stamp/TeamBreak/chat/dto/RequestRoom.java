package com.example.stamp.TeamBreak.chat.dto;

import lombok.Builder;
import lombok.Data;

public class RequestRoom {

    @Builder
    @Data
    public static class create{
        private String name;
    }
}
package com.example.stamp.MngUsrInteractors;

import lombok.Data;

public class RequestDto {

    @Data
    public static class RequestAcceptDto{
        private Long id;

    }

    @Data
    public static class RequestDeleteDto{
        private Long id;

    }
}

package com.example.stamp.코드참고후삭제.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestApi용 컨트롤러! JSON을 반환!
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello(){
        return  "hello world";
    }

}

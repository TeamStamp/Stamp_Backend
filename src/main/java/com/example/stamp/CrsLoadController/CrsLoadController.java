package com.example.stamp.CrsLoadController;


import com.example.stamp.CrsLoadInteractors.CrsLoadServiceImpl;
import com.example.stamp.DataGateway.entity.CrsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CrsLoadController {
    @Autowired
    private CrsLoadServiceImpl CrsLoadServiceImpl;

    //코스 전체 조회
    @GetMapping("/api/course")
    public List<CrsEntity> index(){return CrsLoadServiceImpl.index();}


    //코스 개별 조회
//    @GetMapping("/api/course/{id}")
//    public CrsLoadServiceImpl show(@PathVariable Long id){
//        return CrsLoadServiceImpl.show(id);
//    }
}

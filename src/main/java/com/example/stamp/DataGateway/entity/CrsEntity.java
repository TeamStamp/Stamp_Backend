package com.example.stamp.DataGateway.entity;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CrsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String CrsName;

    @ManyToOne
    @JoinColumn(name = "CrsMakerId", nullable = false)
    private UserEntity CrsMaker;

//    public void add(UserEntity CourseMaker){
//        this.CourseMaker = CourseMaker;
//        CourseMaker.getCourses().add(this);
//    }


}
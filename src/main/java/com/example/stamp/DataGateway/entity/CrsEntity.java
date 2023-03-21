package com.example.stamp.DataGateway.entity;


import com.example.stamp.CrsLoadController.CrsLoadController;
import com.example.stamp.Mnager.controller.FirstController;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class CrsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String CrsName;

    @ManyToOne
    @JoinColumn(name = "CrsMakerId", nullable = false)
    @JsonBackReference
    private UserEntity CrsMaker;



//    public void add(UserEntity CourseMaker){
//        this.CourseMaker = CourseMaker;
//        CourseMaker.getCourses().add(this);
//    }


}
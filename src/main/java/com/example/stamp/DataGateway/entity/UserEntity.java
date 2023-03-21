package com.example.stamp.DataGateway.entity;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private  String Username;
    @Column
    private String UserId;
    @Column
    private String Password;
    //NumberOfStamps(스탬프 수)
    @Column
    private Integer NOS;
    @OneToMany(mappedBy = "CrsMaker",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    private Set<CrsEntity> courses = new HashSet<>();

    public void add(CrsEntity Crs){
        Crs.setCrsMaker(this);       //onwer
       getCourses().add(Crs);
    }




}

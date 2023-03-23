package com.example.stamp.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data

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
    @JsonIgnoreProperties("crsMaker")
    private Set<CrsEntity> courses = new HashSet<>();

    public void add(CrsEntity Crs){
        Crs.setCrsMaker(this);       //onwer
       getCourses().add(Crs);
    }




}

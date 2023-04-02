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
    private Long id;
    @Column
    private  String Nickname;
    @Column
    private String Email;
    @Column
    private String Password;
    @Column
    private String ImgUrl;
    @OneToMany(mappedBy = "UserId",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("UserId")
    private Set<CrsEntity> course = new HashSet<>();
    @OneToMany(mappedBy = "UserId",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("UserId")
    private Set<PlcEntity> place = new HashSet<>();
    public void add(CrsEntity Crs){
        Crs.setUserId(this);       //onwer
       getCourse().add(Crs);
    }
    public void add(PlcEntity Plc){
        Plc.setUserId(this);       //onwer
        getPlace().add(Plc);
    }




}

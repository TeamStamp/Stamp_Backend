package com.example.stamp.Entities;



import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;

@Builder
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




}
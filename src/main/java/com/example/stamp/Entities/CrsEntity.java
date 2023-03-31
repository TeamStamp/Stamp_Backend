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
    private Long Id;

    @Column
    private  String CrsName;
    @Column
    private  String CrsMakerToken;
    @Column
    private Boolean IsAccept;
    @Column
    private String ImageUrl;
//    @ManyToOne
//    @JoinColumn(name = "CrsMakerId", nullable = false)
//    private UserEntity CrsMaker;




}
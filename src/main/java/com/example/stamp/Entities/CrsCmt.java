package com.example.stamp.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class CrsCmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = true)
    private UserEntity UserId;

    @ManyToOne
    @JoinColumn(name = "CrsId", nullable = true)
    private CrsEntity CrsId;

    @Column
    private String Content;


}

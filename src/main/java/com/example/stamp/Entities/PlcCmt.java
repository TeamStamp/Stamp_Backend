package com.example.stamp.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data


public class PlcCmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usr", nullable = true)
    private UserEntity usr;

    @ManyToOne
    @JoinColumn(name = "plc", nullable = true)
    private PlcEntity plc;

    @Column
    private String content;


}

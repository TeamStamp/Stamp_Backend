package com.example.stamp.Entities;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitedCrs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String usrEmail;

    @Column
    private Long crsId;

    @Column
    private String crsName;

    @Column
    private Long crtStamp = 0L;
}

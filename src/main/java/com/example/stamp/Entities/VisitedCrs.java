package com.example.stamp.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitedCrs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long usrId;

    private Long crsId;

    private Long crtStamp;
}

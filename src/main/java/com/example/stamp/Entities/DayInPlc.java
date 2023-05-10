package com.example.stamp.Entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data

public class DayInPlc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date DateTime;
    @ManyToOne
    @JoinColumn(name = "DayId", nullable = true)
    private DayEntity DayId;
    @ManyToOne
    @JoinColumn(name = "PlcId", nullable = true)
    private PlcEntity PlcId;


    @Override
    public int hashCode() {
        return Objects.hash(DayId, PlcId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayInPlc)) return false;
        DayInPlc dayInPlc = (DayInPlc) o;
        return Objects.equals(DayId, dayInPlc.DayId) && Objects.equals(PlcId, dayInPlc.PlcId);
    }

}

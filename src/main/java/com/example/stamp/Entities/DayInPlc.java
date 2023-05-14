package com.example.stamp.Entities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data


public class DayInPlc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "aDay", nullable = true)
    private aDay aDay;
    @ManyToOne
    @JoinColumn(name = "plc", nullable = true)
    private Plc plc;

//
//    @Override
//    public int hashCode() {
//        return Objects.hash(aDay, plc);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayInPlc)) return false;
        DayInPlc dayInPlc = (DayInPlc) o;
        return Objects.equals(aDay, dayInPlc.aDay) && Objects.equals(plc, dayInPlc.plc);
    }

}

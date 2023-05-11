package com.example.stamp.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class DayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer Dayx;
    @ManyToOne
    @JoinColumn(name = "CrsId", nullable = true)
    private CrsEntity CrsId;
    @OneToMany(mappedBy = "DayId",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("DayId")
    private Set<DayInPlc> place = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(Dayx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayEntity)) return false;
        DayEntity day = (DayEntity) o;
        return Objects.equals(Dayx, day.Dayx);
    }
}

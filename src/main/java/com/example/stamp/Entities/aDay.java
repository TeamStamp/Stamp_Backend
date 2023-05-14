package com.example.stamp.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class aDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dayx;
    @ManyToOne
    @JoinColumn(name = "crs", nullable = true)
    private Crs crs;

    @OneToMany(mappedBy = "aDay",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("day")
    private Set<DayInPlc> plc = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(dayx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof aDay)) return false;
        aDay day = (aDay) o;
        return Objects.equals(dayx, day.dayx);
    }
}

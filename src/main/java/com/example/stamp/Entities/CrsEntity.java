package com.example.stamp.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class CrsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String crsName;
    @Column
    private Boolean isAccept;
    @Column
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "usr", nullable = true)
    private UserEntity usr;


    @OneToMany(mappedBy = "crs",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("crs")
    private Set<DayEntity> days = new HashSet<>();
    public void add(DayEntity Day){
        Day.setCrs(this);       //onwer
        getDays().add(Day);
    }

}
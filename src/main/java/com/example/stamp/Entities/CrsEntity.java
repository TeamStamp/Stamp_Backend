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
    private  String CrsName;
    @Column
    private Boolean IsAccept;
    @Column
    private String ImgUrl;
    @ManyToOne
    @JoinColumn(name = "UserId", nullable = true)
    private UserEntity UserId;
    @OneToMany(mappedBy = "CrsId",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("CrsId")
    private Set<DayEntity> Dayx = new HashSet<>();
    public void add(DayEntity Day){
        Day.setCrsId(this);       //onwer
        getDayx().add(Day);
    }

}
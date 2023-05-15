package com.example.stamp.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.*;


@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Plc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private  String plcName;
    //위도
    @Column
    private String lat;
    //경도
    @Column
    private String lng;
    @Column
    private String imgUrl;
    @Column
    private String category;
    @Column
    private Boolean isAccept = false;
    @Column
    private Long cost;
    @ManyToOne
    @JoinColumn(name = "usr")
    private Usr usr;


    @OneToMany(mappedBy = "plc", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<DayInPlc> dayInPlcs = new HashSet<>();

    @OneToMany(mappedBy = "plc",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<PlcCmt> cmt = new ArrayList<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plc)) return false;
        Plc plc = (Plc) o;
        return Objects.equals(plcName, plc.plcName);
    }

}

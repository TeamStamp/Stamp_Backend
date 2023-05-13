package com.example.stamp.Entities;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PlcEntity {
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
    private Boolean isAccept;
    @Column
    private Long cost;
    @ManyToOne
    @JoinColumn(name = "usr")
    private UserEntity usr;


    @OneToMany(mappedBy = "plc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DayInPlc> dayInPlcs;


    @Override
    public int hashCode() {
        return Objects.hash(plcName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlcEntity)) return false;
        PlcEntity plc = (PlcEntity) o;
        return Objects.equals(plcName, plc.plcName);
    }

}

package com.example.stamp.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class PlcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private  String PlcName;
    //위도
    @Column
    private String Lat;
    //경도
    @Column
    private String Lng;
    @Column
    private String ImgUrl;
    @Column
    private String Category;
    @Column
    private Boolean IsAccept;
    @Column
    private Long Cost;
    @ManyToOne
    @JoinColumn(name = "UserId", nullable = true)
    private UserEntity UserId;

    @OneToMany(mappedBy = "PlcId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DayInPlc> dayInPlcs;


    @Override
    public int hashCode() {
        return Objects.hash(PlcName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlcEntity)) return false;
        PlcEntity plc = (PlcEntity) o;
        return Objects.equals(PlcName, plc.PlcName);
    }

}

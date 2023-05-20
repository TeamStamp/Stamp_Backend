package com.example.stamp.Entities;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Crs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String crsName;
    @Column
    private boolean isAccept = false;
    @Column
    private String imgUrl;
    @ManyToOne
    @JoinColumn(name = "usr", nullable = true)
    private Usr usr;


    @OneToMany(mappedBy = "crs",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,orphanRemoval = true)
   // @JsonIgnoreProperties("crs")
    private List<aDay> days = new ArrayList<>();

    @OneToMany(mappedBy = "crs",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
   // @JsonIgnoreProperties("crs")
    private List<CrsCmt> cmt = new ArrayList<>();

    public boolean getIsAccept(){
        return isAccept;
    }
//    public void add(aDay Day){
//        Day.setCrs(this);       //onwer
//        getDays().add(Day);
//    }

}
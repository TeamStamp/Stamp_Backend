package com.example.stamp.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nickname;
    @Column
    private String email;
    @Column
    private String password;

    @Column
    private Long stamp = 0L;

    @Column
    private String salt;

    @Column
    private String imgUrl;

    @Column
    private boolean isAdmin = false;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "usr",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnoreProperties("usr")
    private Set<Crs> crs = new HashSet<>();


    @OneToMany(mappedBy = "usr",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("usr")
    private Set<Plc> plc = new HashSet<>();

//    @Builder
//    public Usr(String email, String password, String nickname, String salt){
//        this.email = email;
//        this.password = password;
//        this.nickname = nickname;
//        this.salt = salt;
//        this.isAdmin = false;
//        this.stamp = 0L;
//    }
    public boolean getIsAdmin(){
        return isAdmin;
    }
    public void update(String password, String nickname, String salt){
        this.password = password;
        this.nickname = nickname;
        this.salt = salt;
    }

}

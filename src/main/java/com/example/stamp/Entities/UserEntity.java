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
public class UserEntity {
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
    private String salt;

    @Column
    private String imgUrl;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "usr",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("usr")
    private Set<CrsEntity> crs = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "usr",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("usr")
    private Set<PlcEntity> plc = new HashSet<>();

    @Builder
    public UserEntity(String email, String password, String nickname, String salt){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.salt = salt;
    }

    public void update(String password, String nickname, String salt){
        this.password = password;
        this.nickname = nickname;
        this.salt = salt;
    }

}

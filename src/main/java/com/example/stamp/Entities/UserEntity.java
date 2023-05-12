package com.example.stamp.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="UserEntity")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nickname")
    private String nickname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @Column(name="salt")
    private String salt;

    @Column
    private String imgUrl;
    @OneToMany(mappedBy = "UserId",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("UserId")
    private Set<CrsEntity> course = new HashSet<>();
    @OneToMany(mappedBy = "UserId",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("UserId")
    private Set<PlcEntity> place = new HashSet<>();

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

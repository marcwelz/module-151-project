package ch.bbw.mw.projekt.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", unique = true)
    private int userid;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "phone", nullable = false)
    private String phone;

}
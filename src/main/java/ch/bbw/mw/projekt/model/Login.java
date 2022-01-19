package ch.bbw.mw.projekt.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "login", indexes = {
        @Index(name = "useridfs", columnList = "useridfs", unique = true)
})
public class Login {

    @Id
    @Column(name = "useridfs", unique = true)
    private int useridfs;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token", nullable = true)
    private String token;

    @Column(name = "admin", nullable = false)
    private boolean admin;

}

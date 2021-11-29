package ch.bbw.mw.projekt.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Login {

    @Id
    @Column(name = "customerIdfs", unique = true)
    private int customerIdfs;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "admin")
    private boolean admin;

}

package ch.bbw.mw.projekt.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "adress")
    private String adress;

    @Column(name = "phone")
    private String phone;

    public User(int id, String username, String adress, String phone) {
        this.id = id;
        this.username = username;
        this.adress = adress;
        this.phone = phone;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
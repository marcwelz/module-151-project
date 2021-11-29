package ch.bbw.mw.projekt.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @JoinTable(name = "user", joinColumns = {@JoinColumn(name = "id")})
    private int customerIdfs;

    @JoinColumn(name = "id", nullable = false)
    private int articleIdfs;

    @Column(name = "totalPrice", nullable = false)
    private double totalePrice;

    @Column(name = "orderTime")
    private LocalDateTime orderTime;

    public Order(int id, int customerIdfs, int articleIdfs, double totalePrice, LocalDateTime orderTime) {
        this.id = id;
        this.customerIdfs = customerIdfs;
        this.articleIdfs = articleIdfs;
        this.totalePrice = totalePrice;
        this.orderTime = orderTime;
    }

    public Order() {
    }
}

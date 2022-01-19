package ch.bbw.mw.projekt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "order", indexes = {
        @Index(name = "useridfs", columnList = "useridfs", unique = false),
        @Index(name = "articleidfs", columnList = "articleidfs", unique = false),
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid", unique = true)
    private int id;

    @OneToOne(optional = false, targetEntity = User.class)
    @JoinColumn(name = "useridfs", nullable = false)
    private int userIdfs;

    @OneToOne(optional = false, targetEntity = Article.class)
    @JoinColumn(name = "articleidfs", nullable = false)
    private int articleidfs;

    @Column(name = "totalprice", nullable = false)
    private double totaleprice;

    @Column(name = "ordertime")
    private LocalDateTime ordertime;


}

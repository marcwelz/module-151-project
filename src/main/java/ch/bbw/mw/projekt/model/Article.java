package ch.bbw.mw.projekt.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "article")

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Article {

    @Id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

}

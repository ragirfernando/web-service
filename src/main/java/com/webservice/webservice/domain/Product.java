package com.webservice.webservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@EqualsAndHashCode(exclude = {"name", "description", "price", "imgUrl", "categories", "items"})
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private Double price;

    @Getter @Setter
    private String imgUrl;

    @Getter
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product(Integer id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    @JsonIgnore
    public Set<Order> getOrders(){
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items) {
            set.add(x.getOrder());
        }
        return set;
    }

}

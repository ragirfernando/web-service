package com.webservice.webservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"name"})
@Entity
@Table(name = "tb_category")
public class Category implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();
}

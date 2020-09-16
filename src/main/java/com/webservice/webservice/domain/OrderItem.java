package com.webservice.webservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webservice.webservice.enums.OrderStatus;
import com.webservice.webservice.pk.OrderItemPK;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"quantity", "price"})
@Entity
@Table(name = "tb_orderItem")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }
}

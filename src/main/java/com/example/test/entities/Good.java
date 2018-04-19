package com.example.test.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer price;
    @OneToMany(fetch = FetchType.LAZY,mappedBy="good",cascade = CascadeType.ALL)
    private Set<OrderLine> orderLine;

    public Good(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(Set<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }
}

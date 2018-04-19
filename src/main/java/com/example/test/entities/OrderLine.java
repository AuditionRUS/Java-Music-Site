package com.example.test.entities;

import javax.persistence.*;

@Entity
@Table(name="orderline")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idB;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "goodsId")
    private Good good;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Order order;
    private Integer count;


    public OrderLine(){

    }

    public Integer getIdB() {
        return idB;
    }

    public void setIdB(Integer idB) {
        this.idB = idB;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

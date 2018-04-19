package com.example.test.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idC;
    private String client;
    private Date date;
    private String address;
    @OneToMany(fetch = FetchType.LAZY,mappedBy="order",cascade = CascadeType.ALL)
    private Set<Order> order;

    public Order(){

    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }
}

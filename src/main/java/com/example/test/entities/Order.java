package com.example.test.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idC;
    private String client;
    private Date date;
    private String address;

    public Order(){

    }

    public int getId() {
        return idC;
    }

    public void setId(int id) {
        this.idC = id;
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
}

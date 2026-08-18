package com.backend.bikescrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bikes")

public class Bikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String BikeName;
    private int cc;
    private Long price;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getBikeName() {
        return BikeName;
    }

    public void setBikeName(String BikeName) {
        this.BikeName = BikeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

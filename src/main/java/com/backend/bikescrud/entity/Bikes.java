package com.backend.bikescrud.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "bikes")

public class Bikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String BikeName;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Engine engine;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

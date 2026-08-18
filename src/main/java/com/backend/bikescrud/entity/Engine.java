package com.backend.bikescrud.entity;

import jakarta.persistence.*;

import java.net.Inet4Address;

@Entity
@Table(name = "Engine")

public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cc;
    private Integer bhp;
    private Integer nm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public int getBhp() {
        return bhp;
    }

    public void setBhp(Integer bhp) {
        this.bhp = bhp;
    }

    public Integer getNm() {
        return nm;
    }

    public void setNm(Integer nm) {
        this.nm = nm;
    }

}

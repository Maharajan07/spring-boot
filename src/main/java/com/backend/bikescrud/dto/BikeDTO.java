package com.backend.bikescrud.dto;

public class BikeDTO {

    private String BikeName;
    private int cc;
    private Long price;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public BikeDTO(String BikeName, int cc) {
        this.BikeName = BikeName;
        this.cc = cc;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        cc = cc;
    }

    public String getBikeName() {
        return BikeName;
    }

    public void setBikeName(String bikeName) {
        BikeName = bikeName;
    }
}

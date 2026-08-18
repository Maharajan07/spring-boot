package com.backend.bikescrud.dto;

public class BikeReqDTO {
    private String BikeName;
    private Double price;
    private Long engineId;

    public Long getEngineId() {
        return engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBikeName() {
        return BikeName;
    }

    public void setBikeName(String bikeName) {
        BikeName = bikeName;
    }
}

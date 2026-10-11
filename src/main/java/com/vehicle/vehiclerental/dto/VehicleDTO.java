package com.vehicle.vehiclerental.dto;

public class VehicleDTO {
    private Long id;
    private String model;
    private String brand;
    private String type;
    private double pricePerDay;
    private boolean available;

    public VehicleDTO() {}

    public VehicleDTO(Long id, String model, String brand, String type, double pricePerDay, boolean available) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.pricePerDay = pricePerDay;
        this.available = available;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPricePerDay() { return pricePerDay; }
    public void setPricePerDay(double pricePerDay) { this.pricePerDay = pricePerDay; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

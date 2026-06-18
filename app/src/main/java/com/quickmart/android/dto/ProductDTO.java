package com.quickmart.android.dto;

public class ProductDTO {

    private String name;
    private Double price;
    private Integer qty;

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getQty() {
        return qty;
    }

    public ProductDTO setQty(Integer qty) {
        this.qty = qty;
        return this;
    }
}
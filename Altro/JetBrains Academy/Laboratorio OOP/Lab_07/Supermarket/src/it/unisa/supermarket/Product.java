package it.unisa.supermarket;

import java.util.GregorianCalendar;

public abstract class Product {

    final private String code;
    final private String description;
    final private String brand;
    private double price;
    private boolean onSale;
    /* TODO */
    private GregorianCalendar lastOnSaleDay;

    public Product(String code, String description, String brand, double price) {
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.price = price;
        /* TODO */
        this.onSale = false;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        /* TODO */
    }

    public void putOnSale(double p, GregorianCalendar g) {
        /* TODO */
    }

    public void checkOnSale() {
        /* TODO */
    }

    public abstract boolean buy(int p);

}

package com.onlinestore.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class CartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne

    private Product product;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private Double totalPrice;

    public CartEntry(long id, Product product, Double quantity, Double totalPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public CartEntry() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}



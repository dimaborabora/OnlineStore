package com.onlinestore.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<CartEntry> cartEntry = new ArrayList<>();

    public Cart(long id, List<CartEntry> cartEntry) {
        this.id = id;
        this.cartEntry = cartEntry;
    }

    public Cart() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CartEntry> getCartEntry() {
        return cartEntry;
    }

    public void setCartEntry(List<CartEntry> cartEntry) {
        this.cartEntry = cartEntry;
    }
}

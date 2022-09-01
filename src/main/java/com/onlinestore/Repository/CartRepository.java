package com.onlinestore.Repository;

import com.onlinestore.Entity.Cart;
import com.onlinestore.Entity.CartEntry;
import com.onlinestore.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CartRepository extends CrudRepository <Cart, Long> {





}

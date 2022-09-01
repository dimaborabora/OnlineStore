package com.onlinestore.Repository;

import com.onlinestore.Entity.CartEntry;
import com.onlinestore.Entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartEntryRepository extends CrudRepository <CartEntry, Long> {
public void deleteCartEntryById (long id);
}

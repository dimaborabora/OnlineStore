package com.onlinestore.Repository;

import com.onlinestore.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository <Product,Long> {

}

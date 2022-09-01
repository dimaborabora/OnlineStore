package com.onlinestore.Repository;

import com.onlinestore.Entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository <Client, Long> {
    Client findByEmail(String email);



}

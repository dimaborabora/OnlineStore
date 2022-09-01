package com.onlinestore.Security;

import com.onlinestore.Repository.ClientRepository;
import com.onlinestore.Entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomClientDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(username);
        if (client == null){
            throw new UsernameNotFoundException("Client not found");
        }
        return new CustomClientDetails(client);
    }
}

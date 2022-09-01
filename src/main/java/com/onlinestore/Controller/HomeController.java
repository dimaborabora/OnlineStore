package com.onlinestore.Controller;

import com.onlinestore.Entity.Client;
import com.onlinestore.Entity.Product;
import com.onlinestore.Repository.ClientRepository;
import com.onlinestore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home (final Model model) {
        return "home";
    }

}

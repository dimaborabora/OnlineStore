package com.onlinestore.Controller;

import com.onlinestore.Entity.Cart;
import com.onlinestore.Entity.Client;
import com.onlinestore.Entity.Product;
import com.onlinestore.Repository.CartRepository;
import com.onlinestore.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/process_register", method = RequestMethod.POST)
    public String register(@ModelAttribute(name = "client") final Client client) {
        String password = client.getPassword();
        client.setPassword(bCryptPasswordEncoder.encode(password));
        Cart cart = new Cart();
        cartRepository.save(cart);
        client.setCart(cart);
        clientRepository.save(client);
        return "redirect:/";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(final Model model) {
        model.addAttribute("client", new Client());
        return "registration";
    }

}

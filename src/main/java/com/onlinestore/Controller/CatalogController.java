package com.onlinestore.Controller;

import com.onlinestore.Entity.Cart;
import com.onlinestore.Entity.CartEntry;
import com.onlinestore.Entity.Product;
import com.onlinestore.Repository.CartEntryRepository;
import com.onlinestore.Repository.CartRepository;
import com.onlinestore.Repository.ClientRepository;
import com.onlinestore.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class CatalogController {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;


    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String showCatalogPage(final Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        model.addAttribute("user", clientRepository.findByEmail(currentPrincipalName));
        model.addAttribute("product", productRepository.findAll());
        model.addAttribute("cart", clientRepository.findByEmail(currentPrincipalName).getCart());
        return "catalog";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {
        return "/logout";
    }


    @PostMapping("/add")
    public String addToCart(@RequestParam(name = "product") final Long productId, final Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        final Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent() && clientRepository.findByEmail(currentPrincipalName).getCart() == null) {
            clientRepository.save(clientRepository.findByEmail(currentPrincipalName));
            Cart cart = new Cart();
            CartEntry cartEntry = new CartEntry();
            cartEntry.setProduct(product.get());
            cartEntry.setQuantity(1.0);
            cartEntry.setTotalPrice(product.get().getPrice() * cartEntry.getQuantity());
            cartEntryRepository.save(cartEntry);
            cart.getCartEntry().add(cartEntry);
            cartRepository.save(cart);
            clientRepository.findByEmail(currentPrincipalName).setCart(cart);
        } else if (product.isPresent()) {
            boolean isFound = false;
            final Cart cart = clientRepository.findByEmail(currentPrincipalName).getCart();
            for (CartEntry c : cart.getCartEntry()) {
                if (c.getProduct().equals(product.get())) {
                    double i = c.getQuantity();
                    c.setQuantity(++i);
                    c.setTotalPrice(product.get().getPrice() * c.getQuantity());
                    cartEntryRepository.save(c);
                    isFound = true;
                }
            }
            if (!isFound) {
                CartEntry cartEntry = new CartEntry();
                cartEntry.setProduct(product.get());
                cartEntry.setQuantity(1.0);
                cartEntry.setTotalPrice(product.get().getPrice() * cartEntry.getQuantity());
                cartEntryRepository.save(cartEntry);
                cart.getCartEntry().add(cartEntry);
                cartRepository.save(cart);
            }
        }
        return "redirect:/catalog";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam(name = "productId") final Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        final Optional<Product> product = productRepository.findById(productId);
        final Cart cart = clientRepository.findByEmail(currentPrincipalName).getCart();
        if (product.isPresent()) {
            for (CartEntry c : cart.getCartEntry()) {
                if (c.getProduct().getId() == product.get().getId()) {
                    cart.getCartEntry().remove(c);
                    cartRepository.save(cart);
                    cartEntryRepository.delete(c);
                    break;
                }
            }
        }
        return "redirect:/catalog";
    }
}

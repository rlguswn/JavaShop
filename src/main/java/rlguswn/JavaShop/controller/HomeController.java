package rlguswn.JavaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.service.ProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = productService.getAllProduct();

        List<Product> todayProducts = new ArrayList<>(products);
        todayProducts.sort(Comparator.comparing(Product::getPrice).reversed());
        if (todayProducts.size() > 8) {
            todayProducts = todayProducts.subList(0, 8);
        }
        model.addAttribute("todayProducts", todayProducts);

        List<Product> limitedProducts = new ArrayList<>(products);
        limitedProducts.sort(Comparator.comparing(Product::getQuantity));
        if (limitedProducts.size() > 8) {
            limitedProducts = limitedProducts.subList(0, 8);
        }
        model.addAttribute("limitedProducts", limitedProducts);

        return "home";
    }
}

package rlguswn.JavaShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rlguswn.JavaShop.domain.Product;
import rlguswn.JavaShop.dto.product.ProductRegisterForm;
import rlguswn.JavaShop.dto.product.ProductUpdateForm;
import rlguswn.JavaShop.service.ProductImageService;
import rlguswn.JavaShop.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductImageService productImageService;

    public ProductController(ProductService productService, ProductImageService productImageService) {
        this.productService = productService;
        this.productImageService = productImageService;
    }

    @GetMapping
    public String getAllProduct(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "product/productList";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "product/productRegister";
    }

    @PostMapping(value = "/register", consumes = "multipart/form-data")
    public String registerProduct(@ModelAttribute ProductRegisterForm form) {
        Product product = productService.registerProduct(form);
        Long productId = product.getId();
        return "redirect:/product/" + productId;
    }

    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        model.addAttribute("product", product);
        return "product/productDetail";
    }

    @GetMapping("/{id}/update")
    public String updatePage(Model model, @PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        model.addAttribute("product", product);
        return "product/productUpdate";
    }

    @PostMapping(value = "/{id}/update", consumes = "multipart/form-data")
    public String updateProduct(Model model, @PathVariable Long id, @ModelAttribute ProductUpdateForm form) {
        Product product = productService.updateProduct(id, form);
        Long productId = product.getId();
        model.addAttribute("product", product);
        return "redirect:/product/" + productId;
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }
}

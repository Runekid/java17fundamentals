package be.onurbugdayci.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionScope
@RequestMapping("/products")
public class ProductController {
    private List<String> products = new ArrayList<>();


    @ModelAttribute("products")
    public List<String> getProducts() {
        return products;
    }

    @GetMapping
    public String handleGet() {
        return "products";
    }

    @PostMapping(params = {"add=add"})
    public String handleAdd(@RequestParam(value = "addproduct") String product) {
        products.add(product);
        return "products";
    }

    @PostMapping(params = {"delete=Del"})
    public String handleDelete(@RequestParam(value = "index") int index) {
        products.remove(index);
        return "products";
    }

    @PostMapping(params = {"change=Change"})
    public String handleChange(@RequestParam(value = "index") int index,
                               @RequestParam(value = "product") String product) {
        products.set(index,product);
        return "products";
    }

}

package be.onurbugdayci.controllers;

import be.onurbugdayci.order.services.ProductOrderService;
import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.product.services.ProductService;
import be.onurbugdayci.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/productList")
    public String forward(Model model) {
        model.addAttribute("products", service.findAllProducts());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return "productList";
    }

    @GetMapping("/product/image/{id}")
    public void showProductImage(@PathVariable long id,
                                 HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg"); // Or whatever format you wanna use

        Product product = service.findProductByID(id);

        InputStream is = new ByteArrayInputStream(product.getImage());
        IOUtils.copy(is, response.getOutputStream());
    }

    @GetMapping(value = "/productDetail/{id}")
    public String productDetail(@PathVariable long id, ModelMap model) {
        model.addAttribute("product", service.findProductByID(id));
        return "productDetail";
    }

    @PostMapping(value = "/search")
    public String searchProducts(String keyword,Model model) {
        model.addAttribute("products",service.findAllProductsWithNameLike(keyword));
        return "productList";
    }

}

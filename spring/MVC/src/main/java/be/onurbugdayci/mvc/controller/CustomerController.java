package be.onurbugdayci.mvc.controller;

import be.onurbugdayci.mvc.domain.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping
    public String forward() {
        return "addressForm";
    }

    @PostMapping
    public String processForm(@ModelAttribute("data") Customer customer) {
        System.out.println(customer.getFirstname());
        return "addressDetail";
    }
}

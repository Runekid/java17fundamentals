package be.onurbugdayci.controllers;

import be.onurbugdayci.order.domain.ProductOrder;
import be.onurbugdayci.order.services.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CartController {


    private final ProductOrderService productOrderService;

    @ModelAttribute("productOrder")
    public ProductOrder getProductOrder() {
        ProductOrder productOrder = productOrderService.findCurrentProductOrder();
        return productOrder;
    }



    @GetMapping("/cart")
    public String forward() {
        return "cart";
    }


    @PostMapping("/productOrderEntryRemove")
    public String removeProductOrderEntry(@RequestParam("productOrderEntryId") long productOrderEntryId) {
        productOrderService.removeProductOrderEntry(productOrderEntryId);

        return "redirect:cart";
    }

    @PostMapping("/productOrderComplete")
    public String completeProductOrder(@RequestParam("productOrderId") long productOrderId) {
        productOrderService.completeProductOrder(productOrderId);
        return "redirect:productList";
    }
}

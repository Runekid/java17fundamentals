package be.onurbugdayci.controllers;

import be.onurbugdayci.order.services.ProductOrderService;
import be.onurbugdayci.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @PostMapping(value = "/productOrder")
    public String handleAddOrder(long productId, @RequestParam(required = false) Integer amount) {
        productOrderService.updateOrCreateProductOrderEntry(productId,amount);
        return "redirect:cart";
    }

}

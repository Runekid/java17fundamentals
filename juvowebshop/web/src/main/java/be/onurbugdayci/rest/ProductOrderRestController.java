package be.onurbugdayci.rest;

import be.onurbugdayci.order.domain.ProductOrderList;
import be.onurbugdayci.order.services.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class ProductOrderRestController {
    private final ProductOrderService service;
    @GetMapping(value = "/orders/today", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductOrderList> findAllOrdersOfToday() {
        ProductOrderList orderList = service.findAllOrdersOfToday();
        return new ResponseEntity(orderList, HttpStatus.OK);

    }

    @GetMapping(value = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductOrderList> findAllOrders() {
        ProductOrderList orderList = service.findAllOrders();
        return new ResponseEntity(orderList, HttpStatus.OK);

    }

    @GetMapping(value = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},params = {"beforeDate"})
    public ResponseEntity<ProductOrderList> findAllOrdersBefore(@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate beforeDate) {
        ProductOrderList orderList = service.findAllByPurchaseDateBefore(beforeDate);
        return new ResponseEntity(orderList, HttpStatus.OK);
    }

    @GetMapping(value = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},params = {"afterDate"})
    public ResponseEntity<ProductOrderList> findAllOrdersAfter(@DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate afterDate) {
        ProductOrderList orderList = service.findAllByPurchaseDateAfter(afterDate);
        return new ResponseEntity(orderList, HttpStatus.OK);
    }

    @GetMapping(value = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},params = {"startDate", "endDate"})
    public ResponseEntity<ProductOrderList> findAllOrdersBetween(@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
        ProductOrderList orderList = service.findAllByPurchaseDateBetween(startDate, endDate);
        return new ResponseEntity(orderList, HttpStatus.OK);
    }
}

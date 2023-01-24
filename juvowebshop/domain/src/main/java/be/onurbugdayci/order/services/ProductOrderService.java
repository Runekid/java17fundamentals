package be.onurbugdayci.order.services;

import be.onurbugdayci.order.domain.ProductOrder;
import be.onurbugdayci.order.domain.ProductOrderList;

import java.time.LocalDate;

public interface ProductOrderService {
    ProductOrder findCurrentProductOrder();
    ProductOrder updateOrCreateProductOrderEntry(long productId, Integer amount);
    ProductOrder removeProductOrderEntry(long productOrderEntryId);
    ProductOrder completeProductOrder(long productOrderId);
    ProductOrderList findAllOrdersOfToday();
    ProductOrderList findAllOrders();
    ProductOrderList findAllByPurchaseDateBefore(LocalDate date);
    ProductOrderList findAllByPurchaseDateAfter(LocalDate date);
    ProductOrderList findAllByPurchaseDateBetween(LocalDate startDate, LocalDate endDate);


}

package be.onurbugdayci.order.services;

import be.onurbugdayci.order.domain.ProductOrderEntry;

public interface ProductOrderEntryService {
    ProductOrderEntry findById(long id);
}

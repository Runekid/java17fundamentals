package be.onurbugdayci.order.mapper;

import be.onurbugdayci.jpa.ProductOrderEntryJPA;
import be.onurbugdayci.order.domain.ProductOrderEntry;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductOrderEntryMapper {
    ProductOrderEntryJPA mapToProductOrderEntryJPA(ProductOrderEntry productOrderEntry);
    ProductOrderEntry mapToProductOrderEntry(ProductOrderEntryJPA productOrderEntryJPA);
}

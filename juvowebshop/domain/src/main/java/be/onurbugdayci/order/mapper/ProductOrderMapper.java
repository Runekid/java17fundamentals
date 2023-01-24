package be.onurbugdayci.order.mapper;

import be.onurbugdayci.jpa.ProductOrderJPA;
import be.onurbugdayci.order.domain.ProductOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductOrderMapper {
    ProductOrderJPA mapToProductOrderJPA(ProductOrder productOrder);
    ProductOrder mapToProductOrder(ProductOrderJPA productOrderJPA);

}

package be.onurbugdayci.order.services;

import be.onurbugdayci.jpa.ProductOrderEntryJPA;
import be.onurbugdayci.order.domain.ProductOrderEntry;
import be.onurbugdayci.order.mapper.ProductOrderEntryMapper;
import be.onurbugdayci.repositories.ProductOrderEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("productOrderEntryService")
@RequiredArgsConstructor
public class ProductOrderEntryServiceImpl implements ProductOrderEntryService {

    private final ProductOrderEntryRepository repository;
    private final ProductOrderEntryMapper mapper;

    @Override
    public ProductOrderEntry findById(long id) {
        Optional<ProductOrderEntryJPA> productOrderEntryJPA = repository.findById(id);
        if (productOrderEntryJPA.isPresent()) return mapper.mapToProductOrderEntry(productOrderEntryJPA.get());
        return null;
    }
}

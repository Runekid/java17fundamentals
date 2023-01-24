package be.onurbugdayci.repositories;

import be.onurbugdayci.jpa.ProductOrderEntryJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderEntryRepository extends JpaRepository<ProductOrderEntryJPA,Long> {
}

package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

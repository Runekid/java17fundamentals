package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Brewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrewerRepository extends JpaRepository<Brewer,Integer> {
}

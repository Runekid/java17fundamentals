package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Beer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeerRepositoryTest {
	@Autowired
	private BeerRepository beerRepository;
	
	@Test
	public void testGetBeerById(){
		Beer beer = beerRepository.getBeerById(1);
		Assertions.assertEquals("TestBeer", beer.getName());
	}

	@Test
	public void testUpdateBeer(){
		Beer beer = beerRepository.getBeerById(1);
		int stock = beer.getStock();
		beer.setStock(stock-5);
		beerRepository.updateBeer(beer);
		beer = beerRepository.getBeerById(1);
		Assertions.assertEquals(stock-5, beer.getStock());
	}

	@Test
   public void testGetBeerByAlcohol(){
	   List<Beer> beers = beerRepository.getBeerByAlcohol(7);
	   for(Beer b: beers) {
	      Assertions.assertEquals(7,b.getAlcohol(),0.1F);
	   }
   }
}

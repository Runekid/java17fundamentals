package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.BeerOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@WithMockUser(username = "homer", password = "password", roles = "ADULT")
public class BeerServiceImplTest {
    @Autowired
    private BeerService beerService;

    @Autowired
    private BeerOrderRepository beerOrderRepository;

    @Test
    public void orderBeerTest() throws InvalidNumberException, InvalidBeerException {

        int beerOrderId = beerService.orderBeer("onur",1,1);
        BeerOrder beerOrder = beerOrderRepository.findById(beerOrderId).get();
        assertEquals(beerOrder.getName(), "onur");

    }
}

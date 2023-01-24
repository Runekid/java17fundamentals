package be.onurbugdayci.beers.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeerDaoTest {
    @Autowired
    private BeerDao dao;

    @Test
    public void testGetBeerById() {
        String beer = dao.getBeerById(2506);
        assertEquals("TesBeer 7.0 2.75 100", beer);
    }

    @Test
    public void testGetBeerByAlcohol() {
        List<String> beer = dao.getBeerByAlcohol(7F);
        assertEquals(1, beer.size());
        assertEquals("TestBeer 7.0 2.75 100", beer.get(0));
    }
}

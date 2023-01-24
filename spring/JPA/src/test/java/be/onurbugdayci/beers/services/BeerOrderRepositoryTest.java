package be.onurbugdayci.beers.services;

import be.onurbugdayci.beers.domain.Beer;
import be.onurbugdayci.beers.domain.BeerOrder;
import be.onurbugdayci.beers.domain.BeerOrderItem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeerOrderRepositoryTest {
   @Autowired
   private BeerOrderRepository orderRepo;
   
   @Autowired
   private BeerRepository beerRepo;

   @Test
   public void testSaveOrder() {
      Beer beer = beerRepo.getBeerById(1);
      BeerOrderItem item = new BeerOrderItem();
      item.setBeer(beer);
      item.setNumber(5);
      
      BeerOrder order = new BeerOrder();
      order.setName("Homer");
      order.getItems().add(item);

      int id = orderRepo.saveOrder(order);

      order = orderRepo.getBeerOrderById(id);
      Assertions.assertEquals("Homer", order.getName());
      Assertions.assertEquals("TestBeer",
            order.getItems().get(0).getBeer().getName());

   }   
}

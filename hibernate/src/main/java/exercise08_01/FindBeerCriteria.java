package exercise08_01;

import java.util.*;

public class FindBeerCriteria {
   public static void main(String[] args) {
      BeerRepository repository = new BeerRepository();
      repository.init();

      List<Beer> beers = repository.getBeersByCriteria(null,null,null,"Amber");
      for(Beer beer: beers) {
         System.out.println(beer);
         System.out.println(beer.getBrewer().getName());
      }

      repository.close();
   }
}

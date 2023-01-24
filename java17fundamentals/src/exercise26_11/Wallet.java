package exercise26_11;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Wallet {
   public static void main(String[] args) {
      Map<Coin,AtomicInteger> wallet = new ConcurrentHashMap<>();
      
      wallet.put(Coin.ONE_CENT, new AtomicInteger(2));
      wallet.put(Coin.TWO_CENT, new AtomicInteger(3));
      wallet.put(Coin.FIVE_CENT, new AtomicInteger(8));
      wallet.put(Coin.TEN_CENT, new AtomicInteger(1));
      wallet.put(Coin.TWENTY_CENT, new AtomicInteger(0));
      wallet.put(Coin.FIFTY_CENT, new AtomicInteger(9));
      wallet.put(Coin.ONE_EURO, new AtomicInteger(7));
      wallet.put(Coin.TWO_EURO, new AtomicInteger(1));
      
      int sum = 0;
      for(Coin c: wallet.keySet()){
         System.out.println(c.name() + " : " + wallet.get(c));
         sum+= c.getValue() * wallet.get(c).get();
      }
      
      System.out.println((sum/100F) + " € ");      
   }
}

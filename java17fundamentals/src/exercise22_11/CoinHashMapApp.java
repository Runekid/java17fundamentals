package exercise22_11;

import java.util.*;

public class CoinHashMapApp {

    public static void main(String[] args) {
        Map<Coin,Integer> wallet = new LinkedHashMap<>();
        wallet.put(Coin.ONE_CENT,2);
        wallet.put(Coin.TWO_CENTS,4);
        wallet.put(Coin.FIVE_CENTS,8);
        wallet.put(Coin.TEN_CENTS,16);
        wallet.put(Coin.TWENTY_CENTS,32);
        wallet.put(Coin.FIFTY_CENTS,64);
        wallet.put(Coin.TWO_EURO,256);
        wallet.put(Coin.ONE_EUR,128);


        wallet.forEach((k,v) -> System.out.println("Money " + k + " Amount " + v)); //Met linked hash map is de volgorde van input in de map bewaard
        float total = wallet.entrySet().stream().mapToInt(entry -> entry.getKey().getValue() * entry.getValue()).sum();
        System.out.println(total);

        /*wallet.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey().getValue()))
                .forEach(entry -> System.out.println("Money " + entry.getKey() + " Amount " + entry.getValue()));*/

       //Dit heb ik van de solution, ander manier op het bovenste te doen
        wallet.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach((e) -> System.out.format("%s : %d%n",e.getKey(),e.getValue()));


    }
}

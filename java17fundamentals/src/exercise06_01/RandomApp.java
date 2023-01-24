package exercise06_01;
import java.util.*;
public class RandomApp {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt(1,100));
        lotto();

    }

    public static void lotto() {
        Random rand = new Random();
        for(int i=0;i<6;i++) {
            System.out.println(rand.nextInt(0,45));
        }
    }
}

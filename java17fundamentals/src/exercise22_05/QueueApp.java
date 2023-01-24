package exercise22_05;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue<BurgerOrder> burgerList = new PriorityQueue<>();
        BurgerOrder bo1 = new BurgerOrder("Supreme bacon", 1);
        BurgerOrder bo2 = new BurgerOrder("Supreme chicken", 2);
        burgerList.offer(bo1);
        burgerList.offer(bo2);

        BurgerOrder current = burgerList.peek();
        while (current != null) {
            System.out.println("About to handle: " + current.getName());
            System.out.println("Handling " + burgerList.poll().getName());
            current = burgerList.peek();

        }

        // ik krijg een exception als ik priority que gebruik ipv LinkedList omdat BurgerOrder niet gecast kan worden naar Comparable
    }
}

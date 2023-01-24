package exercise13_04;

import java.util.Scanner;

public interface KeyboardUtility {
   public static int readInt() {
      Scanner keyboard = new Scanner(System.in);
      int value = keyboard.nextInt();
      return value;
   }
}

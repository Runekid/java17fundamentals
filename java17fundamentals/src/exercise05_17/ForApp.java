package exercise05_17;

public class ForApp {
    public static void main(String[] args) {
        /*for (int i=400; i>=350;i--) {
            System.out.println(i);
        }*/

        /*for (int i=7;i<200;i+=7) {
            System.out.println(i);
        }*/

        /*for (int i=1;i<100000;i*=11) {
            System.out.println(i);
        }*/

        /*for (char letter = 'z'; letter >= 'a'; letter--) {
            System.out.println(letter);
        }*/

        /*for (int i = -10; i <= 10; i++) {
            System.out.println(i > 0 ? "+" + i : i);
        }*/

        /*for (int i = 0; i <= 10000; i++) {
            if (i % 6 == 0 && i % 28 == 0) System.out.println(i);
        }*/

        final int MAX = 10000;
        int count = 0;
        for(int number = 2; number <= MAX; number++) {
            boolean isPrime = true;
            for (int i = 2; (i < number) && isPrime; i++) {
                isPrime = ((number % i) != 0);
            }
            if (isPrime) {
                System.out.println(number);
                count++;
            }
        }
        System.out.println("Number of primes " + count);
    }
}

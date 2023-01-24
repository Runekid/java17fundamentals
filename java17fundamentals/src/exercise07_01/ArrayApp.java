package exercise07_01;

public class ArrayApp {
    public static void main(String[] args) {
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = 7 * (i + 1);
        }
        System.out.println(numbers.length);
        for (int num: numbers) {
            System.out.println(num);
        }
        for (int i=19;i>=0;i--) {
            System.out.println(numbers[i]);
        }

        boolean[] bools = {true,false,true};
        for(boolean bool: bools) {
            System.out.println(bool);
        }



        final int MAX = 10000;
        int[] primeNums = new int[MAX / 4];
        int count = 0;
        for(int number = 2; number <= MAX; number++) {
            boolean isPrime = true;
            for (int i = 0; (i < count) && isPrime && ((primeNums[i]*primeNums[i]) <= number); i++) {
                isPrime = ((number % primeNums[i]) != 0);
            }
            if (isPrime) {

                primeNums[count++] = number;
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println(primeNums[i]);
        }
        System.out.println("Number of primes " + count);


    }
}

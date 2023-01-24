package exercise05_08;

public class ShiftOpsApp {
    public static void main(String[] args) {
        int number1 = 8;
        int number2 = 2;

        System.out.println("number1 is 8 and number2 is 2");
        System.out.println("number1 << number2: " + (number1 << number2));
        System.out.println("number1 >> number2: " + (number1 >> number2));
        System.out.println("number1 >>> number2: " + (number1 >>> number2));

        number1 = -8;
        System.out.println("number1 is now -8");
        System.out.println("number1 >> number2: " + (number1 >> number2));
        System.out.println("number1 >>> number2: " + (number1 >>> number2));

        long hdd = 240_054_693_888L;

        System.out.println("bytes: " + (hdd >> 0)); // move 0 spaces
        System.out.println("KB: " + (hdd >> 10)); // 2^10 is 1024 and result is same as hdd / 1024
        System.out.println("MB: " + (hdd >> 20)); // same logic as KB
        System.out.println("GB: " + (hdd >> 30)); // same logic as KB

    }
}

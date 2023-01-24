package exercise05_05;

public class DataTypesApp {
    public static void main(String[] args) {
        byte aByte1 = 5;
        byte aByte2 = 6;
        byte aByte3 = (byte) (aByte1 * aByte2);

        int anInteger1 = 2147483645;
        int anInteger2 = 2147483642;
        int anInteger3 = anInteger1 * anInteger2; // max value of int is passed

        System.out.println(anInteger3);

        long aBigInteger = (long) anInteger1 * anInteger2; // change an operand to long so result of product becomes long

        System.out.println(aBigInteger);
    }
}

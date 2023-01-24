package exercise05_04;

public class OperatorsApp {

    public static void main(String[] args) {
        int number1 = 5, number2 = 6;
        System.out.println("sum of number 1 and 2: " + (number1 + number2));
        System.out.println("diff of number 1 and 2: " + (number1 - number2));
        System.out.println("product of number 1 and 2: " + (number1 * number2));
        System.out.println("deling of number 1 and 2: " + (number1 / number2));
        System.out.println("mod of number 1 and 2: " + (number1 % number2));
        System.out.println("--number1: "  + --number1 ); // output 4 because 1 is removed before
        System.out.println("number1--: "  + number1-- ); // output 4 and value becomes 3 after
        System.out.println("++number1: "  + ++number1 ); // output 4 because 1 is added before
        System.out.println("number1++: "  + number1++ ); // output 4 and value becomes 5 after

        char aCharacter = 'q';
        System.out.println(++aCharacter);
    }
}

package exercise06_06;

public class FormatApp {
    public static void main(String[] args) {
        for (double meter = 1; meter <= 20; meter += 0.5) {
            double feet = 3.281 * meter;
            System.out.printf("%.2f meters = %.2f feet %n", meter, feet);
        }
    }
}

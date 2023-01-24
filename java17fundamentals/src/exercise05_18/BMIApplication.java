package exercise05_18;

public class BMIApplication {
    public static void main(String[] args) {
        System.out.print("Enter your length (cm): ");
        int height = KeyboardUtility.readInt();
        System.out.print("Enter your weight (kg): ");
        int weight = KeyboardUtility.readInt();
        float bmi = BmiUtility.calculateBmi(weight, height);
        BmiUtility.printDiagnose(bmi);
    }
}

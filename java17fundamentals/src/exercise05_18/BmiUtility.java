package exercise05_18;

public class BmiUtility {
    public static float calculateBmi(int weight, int height) {
        float bmi = weight / ((height / 100F * height / 100F));
        return bmi;
    }

    public static void printDiagnose(float bmi) {
        if (bmi >= 40) {
            System.out.println("You are severely obese");
        } else if (bmi >= 30) {
            System.out.println("You are obese");
        } else if (bmi >= 25) {
            System.out.println("You are overweight");
        } else if (bmi >= 20) {
            System.out.println("You are ok");
        } else {
            System.out.println("You are underweight");
        }
    }
}

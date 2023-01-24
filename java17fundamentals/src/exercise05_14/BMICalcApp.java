package exercise05_14;

import java.util.Scanner;

public class BMICalcApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your weight in KG:  ");
        float weight = keyboard.nextFloat();
        System.out.print("Enter your height in M:  ");
        float height = keyboard.nextFloat();

        float bmi = weight / (height * height);

        if (bmi >= 40) {
            System.out.println("You are severely obese");
        } else if (bmi >= 30) {
            System.out.println("You are obese");
        } else if (bmi >= 25) {
            System.out.println("You are overweight");
        } else if (bmi >= 20){
            System.out.println("You are ok");
        } else {
            System.out.println("You are underweight");
        }
        keyboard.close();
    }
}

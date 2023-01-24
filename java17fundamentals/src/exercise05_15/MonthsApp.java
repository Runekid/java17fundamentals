package exercise05_15;

import java.util.Scanner;

public class MonthsApp {

    public static void main(String[] args) {
        int days = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter year:  ");
        int year = keyboard.nextInt();
        System.out.print("Enter number of month:  ");
        int month = keyboard.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Invalid number of month");
        } else {
            /* switch (month) {
                case 1:
                    days = 31;
                    break;
                case 2:
                    days = (year % 4 == 0) ? 29 : 28;
                    break;
                case 3:
                    days = 31;
                    break;
                case 4:
                    days = 30;
                    break;
                case 5:
                    days = 31;
                    break;
                case 6:
                    days = 30;
                    break;
                case 7:
                    days = 31;
                    break;
                case 8:
                    days = 31;
                    break;
                case 9:
                    days = 30;
                    break;
                case 10:
                    days = 31;
                    break;
                case 11:
                    days = 30;
                    break;
                case 12:
                    days = 31;
                    break;

                default:
                    days = 0;

            } */

            days = switch (month) {
                case 2 -> {
                    if (year % 4 == 0) {
                        yield 29;
                    } else {
                        yield 28;
                    }
                }
                case 4, 6, 9, 11 -> 30;
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                default -> 0;

            };
        }
        System.out.println("Number of days: " + days);

        keyboard.close();
    }
}

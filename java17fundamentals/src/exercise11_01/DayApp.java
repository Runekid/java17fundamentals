package exercise11_01;

public class DayApp {
    public static void main(String[] args) {
        for (Day d : Day.values()) {
            System.out.printf("%20s %20s %20s %20s %n", d.name(), d.ordinal(), d.toString(), d.isWeekDay());
        }
    }
}

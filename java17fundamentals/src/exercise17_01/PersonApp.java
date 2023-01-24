package exercise17_01;

public class PersonApp {
    public static void main(String[] args) {
        Person p = new Person("Onur", "Bugdayci", 25);
        Person p2 = new Person("Onur", "Bugdayci", 25);
        System.out.println(p.toString());
        System.out.println(p.firstName());
        System.out.println(p.lastName());
        System.out.println(p.age());
        System.out.println(p.equals(p2));
        System.out.println(p.hashCode() == p2.hashCode());
    }
}

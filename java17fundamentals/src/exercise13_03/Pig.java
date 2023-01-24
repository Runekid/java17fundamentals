package exercise13_03;

public interface Pig {
    void grunt();
    default void fly() {
        System.out.println("flying");
    }
}

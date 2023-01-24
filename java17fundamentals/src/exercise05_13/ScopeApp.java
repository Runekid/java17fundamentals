package exercise05_13;

public class ScopeApp {
    public static void main(String[] args) {
        {
            int scope = 1;
        }
        {
            int scope = 2; //this one is printed
            System.out.println(scope);
        }

    }
}

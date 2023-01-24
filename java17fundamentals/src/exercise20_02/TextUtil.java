package exercise20_02;

public interface TextUtil {
    static String reverse(String s) {

        return new StringBuilder(s).reverse().toString();
    }
}

package exercise05_15;

import java.io.IOException;

public class ScrabbleApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter character: ");
        char c = (char) System.in.read();
        int value = switch (c) {
            case 'a', 'e', 'n', 'i', 'o' -> 1;
            case 'd', 'r', 's', 't' -> 2;
            case 'g', 'k', 'l', 'm', 'b', 'p' -> 3;
            case 'u', 'f', 'h', 'j', 'v', 'z' -> 4;
            case 'c', 'w' -> 5;
            case 'x', 'y' -> 8;
            case 'q' -> 10;
            default -> 0;
        };
        System.out.println("Scrabble value: " + value);
    }
}

package exercise20_01;

public class TextPrinterApp {
    public static void main(String[] args) {
        TextPrinter textPrinter = new TextPrinter("Dit is een test");
        textPrinter.printValidWords(word -> word.startsWith("e"));
        textPrinter.printValidWords(word -> word.endsWith("t"));
        textPrinter.printValidWords(word -> word.length() == 3);
    }
}

package exercise20_02;

import java.math.BigDecimal;

public class TextPrinterApp {
    public static void main(String[] args) {
        TextPrinter textPrinter = new TextPrinter("2 3 Dit 1 is 5 7 77");
        TextScrambler textScrambler = new TextScrambler();

        textPrinter.printProcessedWords(TextUtil::reverse);
        textPrinter.printProcessedWords(textScrambler::scramble);
        textPrinter.printProcessedWords(String::toLowerCase);
        //textPrinter.printNumberValues(BigDecimal::new);
        textPrinter.printSum(BigDecimal::new);
    }
}

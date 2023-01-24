package exercise20_02;


import java.math.BigDecimal;

public class TextPrinter {
    private String sentence;

    public TextPrinter(String sentence) {
        this.sentence = sentence;
    }

    public void printProcessedWords(WordProcessor processor) {
        System.out.println(processor.process(sentence));
    }

    public void printNumberValues(NumberParser numberParser) {

        System.out.println(numberParser.parse(sentence));

    }

    public void printSum(NumberParser numberParser) {
        BigDecimal total = new BigDecimal(0);

        for (String s : sentence.split(" ")) {

            try {
                total = total.add(numberParser.parse(s));
            } catch (NumberFormatException nfe) {

            }
        }
        System.out.println(total);
    }

}

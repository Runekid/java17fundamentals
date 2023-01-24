package exercise20_01;

public class TextPrinter {
    private String sentence;

    public TextPrinter(String sentence) {
        this.sentence = sentence;
    }


    public void printValidWords(WordFilter wf) {
        for (String s : sentence.split(" ")) {
            if (wf.isValid(s)) System.out.println(s);

        }

    }
}

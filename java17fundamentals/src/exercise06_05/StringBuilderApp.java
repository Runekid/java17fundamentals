package exercise06_05;

public class StringBuilderApp {
    public static void main(String[] args) {
        StringBuilder text1 = new StringBuilder("firstText");
        StringBuilder text2 = new StringBuilder("secondText");
        System.out.println(text1);
        System.out.println(text2);

        System.out.println(text1.append(" stukje tekst"));
        System.out.println(text2.reverse());

        for (int i=0;i<text1.length();i++) {
            if (text1.charAt(i) == ' ') text1.deleteCharAt(i--);
        }
        System.out.println(text1);
        for (int i=0; i<text2.length();i++) {
            if (text2.charAt(i) == 't') text2.insert(i++,'t');
        }
        System.out.println(text2); // big T is different than small t
    }
}

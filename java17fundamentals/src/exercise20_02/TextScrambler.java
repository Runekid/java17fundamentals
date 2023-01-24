package exercise20_02;

public class TextScrambler {
    public String scramble(String s) {

        return s.replaceAll("a", "@")
                .replaceAll("e","€")
                .replaceAll("i","1")
                .replaceAll("o","0");
    }
}

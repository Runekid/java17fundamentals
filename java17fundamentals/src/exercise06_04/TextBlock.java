package exercise06_04;

public class TextBlock {

    public static void main(String[] args) {
        String json = """
                {
                    "firstName" : "Homer",
                    "lastName": "Simpson",
                    "address": "742 Evergreen Terrace, SpringField",
                    "description": "homer Jay Simpson is a fictional character and 
                    of the main characters of the American animated sitcom The
                    Simpsons."
                }
                """;
        System.out.println(json);
    }
}

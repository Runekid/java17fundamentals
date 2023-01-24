package exercise23_11;

import java.io.IOException;

public class TestProg1 {
    public static void main(String[] args) {
        ApplicationProperties applicationProperties = new ApplicationProperties("app.properties");
        applicationProperties.setHeight(1);
        applicationProperties.setWidth(2);
        applicationProperties.setX(3);
        applicationProperties.setY(4);
        try {
            applicationProperties.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

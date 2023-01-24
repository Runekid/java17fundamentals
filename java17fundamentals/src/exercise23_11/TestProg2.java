package exercise23_11;

import java.io.IOException;

public class TestProg2 {
    public static void main(String[] args) {
        ApplicationProperties applicationProperties = new ApplicationProperties("app.properties");
        try {
            applicationProperties.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("%d %d %d %d",applicationProperties.getHeight(),applicationProperties.getWidth(),applicationProperties.getX(),applicationProperties.getY() );
    }
}

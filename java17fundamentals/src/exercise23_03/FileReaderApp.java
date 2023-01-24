package exercise23_03;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderApp {
    public static void main(String[] args) {
        try(FileReader fileReader = new FileReader("exercise23_02.txt")) {
            int character = fileReader.read();
            while(character != -1) {
                System.out.print((char) character);
                character = fileReader.read();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

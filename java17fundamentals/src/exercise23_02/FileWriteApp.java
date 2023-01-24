package exercise23_02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class FileWriteApp {
    public static void main(String[] args) {


        try (FileWriter file = new FileWriter("exercise23_02.txt",true)){
            file.write("\nStukje tekst3");




        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        //Read lines of text from file
        try {
            Path path = Paths.get("exercise23_02.txt");
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

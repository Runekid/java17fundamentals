package exercise23_04;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriterApp {
    public static void main(String[] args) {
        try (FileWriter file = new FileWriter("exercise23_02.txt",true); BufferedWriter bufferedWriter = new BufferedWriter(file)){
            bufferedWriter.newLine(); //voordeel van buffered writer is dat je een newLine() methode hebt?
            bufferedWriter.write("stukje tekst");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        //Read lines of text from file
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("exercise23_02.txt"))){
            String line = bufferedReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

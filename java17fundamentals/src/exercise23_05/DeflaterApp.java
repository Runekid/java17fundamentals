package exercise23_05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class DeflaterApp {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("compressed.bin");
             DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(fileOutputStream);
             PrintStream printStream = new PrintStream(deflaterOutputStream)) {

            printStream.println("hey");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream("compressed.bin");
             InflaterInputStream inflaterInputStream = new InflaterInputStream(fileInputStream);
             // InputStream inputStream -> is abstract
             InputStreamReader inputStreamReader = new InputStreamReader(inflaterInputStream)){
            int character = inputStreamReader.read();
            while (character != -1) {
                System.out.print((char) character);
                character = inputStreamReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

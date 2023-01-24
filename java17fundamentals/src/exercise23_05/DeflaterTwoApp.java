package exercise23_05;

import java.io.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class DeflaterTwoApp {
    //Instead of a file we now use ByteArrayOutputStream en ByteArrayInputStream
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            PrintStream printStream = new PrintStream(deflaterOutputStream);


            printStream.println("hey");
            printStream.close(); //have to close this stream so i can read from it

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(inflaterInputStream);
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

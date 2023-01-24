package exercise23_01;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class PathsApp {
    public static void main(String[] args) {

        try {
            //Define path
            Path path = Paths.get("C:\\data\\files\\file1.txt");

            //Create parent directories
            Files.createDirectories(path.getParent());

            //Create file if not exists
            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }

            //Write lines of text to file
            List<String> lines = new ArrayList<>();
            lines.add("Hello");
            lines.add("World");
            Files.write(path, lines, Charset.defaultCharset(), StandardOpenOption.APPEND);

            //Retrieve attributes of file
            DosFileAttributes attributes = Files.readAttributes(path, DosFileAttributes.class);

            System.out.println(attributes.size());
            System.out.println(attributes.creationTime());
            System.out.println(attributes.lastAccessTime());
            System.out.println(attributes.lastModifiedTime());
            System.out.println(attributes.isArchive());
            System.out.println(attributes.isHidden());
            System.out.println(attributes.isReadOnly());

            //Read lines of text from file
            Files.lines(path).forEach(System.out::println);

            //Retrieve owner from file
            System.out.println(Files.getOwner(path));

            //rename file

            Path renamedPath = Paths.get("C:\\data\\files\\renamedFile.txt");
            Files.move(path,renamedPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

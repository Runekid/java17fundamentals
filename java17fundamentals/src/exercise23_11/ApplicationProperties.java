package exercise23_11;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ApplicationProperties {
    private Path file;
    private final static String XPOS = "X-position";
    private final static String YPOS = "Y-position";
    private final static String WIDTH = "Width";
    private final static String HEIGHT = "Height";
    private Properties props = new Properties();

    public ApplicationProperties(String filename) {
        file = Paths.get(filename);
    }

    public void load() throws IOException {
        if (Files.exists(file)) {
            try (InputStream in = Files.newInputStream(file)) {
                props.load(in);
            }
        }
    }

    public void store() throws IOException {
        try (OutputStream out = Files.newOutputStream(file)) {
            props.store(out, "Application properties");
        }
    }

    public void setX(int x) {
        props.setProperty(XPOS, Integer.toString(x));
    }

    public Integer getX() {
        int x = 0;
        try {
            x = Integer.parseInt(props.getProperty(XPOS, "0"));
        } catch (NumberFormatException ex) {
        }
        return x;
    }

    public void setY(int y) {
        props.setProperty(YPOS, Integer.toString(y));
    }

    public int getY() {
        int y = 0;
        try {
            y = Integer.parseInt(props.getProperty(YPOS, "0"));
        } catch (NumberFormatException ex) {
        }
        return y;
    }

    public void setWidth(int w) {
        props.setProperty(WIDTH, Integer.toString(w));
    }

    public int getWidth() {
        int w = 500;
        try {
            w = Integer.parseInt(props.getProperty(WIDTH, "500"));
        } catch (NumberFormatException ex) {
        }
        return w;
    }

    public void setHeight(int h) {
        props.setProperty(HEIGHT, Integer.toString(h));
    }

    public int getHeight() {
        int h = 300;
        try {
            h = Integer.parseInt(props.getProperty(HEIGHT, "300"));
        } catch (NumberFormatException ex) {
        }
        return h;
    }
}

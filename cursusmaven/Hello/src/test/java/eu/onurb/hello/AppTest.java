package eu.onurb.hello;
import static org.junit.Assert.*;
import org.junit.*;

public class AppTest {

    @Test
    public final void testSayHello() {
        App app = new App();
        String text = app.sayHello();
        assertEquals("Hello World", text);
    }

}
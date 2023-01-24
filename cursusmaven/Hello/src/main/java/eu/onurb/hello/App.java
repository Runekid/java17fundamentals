package eu.onurb.hello;
import org.apache.logging.log4j.*;

/**My own application class
 *
 * @author Onur; Bugdayci
 *
 */
public class App {
    private static Logger logger = LogManager.getLogger();

    /**
     * This nethod says hello to the world
     * @return "Hello World"
     */
    public String sayHello() {
        logger.debug("Somebody called sayHello()");
        return "Hello World";
    }

    public static void main(String[] args) {        
        App app = new App();
        System.out.println(app.sayHello());
    }
}
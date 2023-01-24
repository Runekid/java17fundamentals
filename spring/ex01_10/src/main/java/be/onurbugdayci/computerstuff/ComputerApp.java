package be.onurbugdayci.computerstuff;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(ComputerAppConfig.class);
        Computer computer = ctx.getBean("computer", Computer.class);
        System.out.println(computer);
    }
}

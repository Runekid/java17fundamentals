package be.onurbugdayci;

import be.onurbugdayci.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import java.io.IOException;
import java.net.URISyntaxException;


@SpringBootApplication
@EnableJpaRepositories
public class resApp {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ConfigurableApplicationContext ctx = SpringApplication.run(resApp.class, args);
        ProductRepository productRepository = ctx.getBean("productRepository", ProductRepository.class);

        productRepository.findAll().forEach(System.out::println);

        //retrieveAndSaveImage
        /*Product productFromDB = productRepository.getProductById(product.getId());
        ByteArrayInputStream bis = new ByteArrayInputStream(productFromDB.getImage());
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "jpg", new File("output.jpg") );
        System.out.println("image created");*/

    }
}

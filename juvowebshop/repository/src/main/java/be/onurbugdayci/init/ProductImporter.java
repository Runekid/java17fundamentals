package be.onurbugdayci.init;

import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.repositories.ProductRepository;
import be.onurbugdayci.resApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class ProductImporter implements CommandLineRunner {
    private ProductRepository productRepository;

    @Autowired
    public ProductImporter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(String filename, String productName, String productDescription, BigDecimal productPrice) throws IOException, URISyntaxException {
        URL res = resApp.class.getClassLoader().getResource(filename);
        Path pathEend = Paths.get(res.toURI());
        byte[] pictureEend = Files.readAllBytes(pathEend);
        ProductJPA product = new ProductJPA();
        product.setName(productName);
        product.setDescription(productDescription);
        product.setPrice(productPrice);
        product.setImage(pictureEend);
        productRepository.save(product);
    }

    @Override
    public void run(String... args) throws Exception {
        createProduct("eend.jpg", "eend", "Nooit meer eenzaam in bad! Het is\n" +
                "ook een leuke gesprekspartner.", new BigDecimal("15.00"));

        createProduct("groot_notitieblok.jpg","groot notititeblok", "Schrijven doen we niet vaak, maar\n" +
                "als we het doen dan doen we het\n" +
                "tegoei!", new BigDecimal("10.00"));
        createProduct("klein_notitieblok.jpg", "klein notitieblok", "Voor als we toch niet zoveel willen\n" +
                "schrijven", new BigDecimal("7.50"));
        createProduct("post_it.jpg", "post-it", "Kleine ideeën zijn goud waard.", new BigDecimal("5.0"));
        createProduct("pen.jpg", "pen", "Hiermee schrijf je zoals nooit tevoren!\n" +
                "Wie heeft er nog technologie nodig?\n", new BigDecimal("2.50"));
    }
}

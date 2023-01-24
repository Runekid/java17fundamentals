package be.onurbugdayci.product.mapper;

import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.jpa.ProductJPA;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductJPA mapToProductJPA(Product product);
    Product mapToProduct(ProductJPA productJPA);

    /*public ProductJPA mapToProductJPA(Product product) {
        ProductJPA productJPA = new ProductJPA();
        productJPA.setId(product.getId());
        productJPA.setName(product.getName());
        productJPA.setDescription(product.getDescription());
        productJPA.setPrice(product.getPrice());
        return productJPA;
    }

    public Product mapToProductJPA(ProductJPA productJPA) {
        Product product = new Product();
        product.setId(productJPA.getId());
        product.setName(productJPA.getName());
        product.setDescription(productJPA.getDescription());
        product.setPrice(productJPA.getPrice());
        return product;
    }*/

}

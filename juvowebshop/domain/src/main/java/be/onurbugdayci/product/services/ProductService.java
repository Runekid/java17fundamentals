package be.onurbugdayci.product.services;


import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.product.domain.Product;

import java.awt.color.ProfileDataException;
import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    List<Product> findAllProductsWithNameLike(String name);
    Product findProductByID(long id);
}

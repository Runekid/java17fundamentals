package be.onurbugdayci.product.services;

import be.onurbugdayci.jpa.ProductJPA;
import be.onurbugdayci.product.domain.Product;
import be.onurbugdayci.product.mapper.ProductMapper;
import be.onurbugdayci.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findAllProducts() {
        List<ProductJPA> productJPAS = productRepository.findAll();
        return productJPAS
                .stream()
                .map(jpa -> productMapper.mapToProduct(jpa))
                .toList();
    }

    @Override
    public List<Product> findAllProductsWithNameLike(String name) {
        List<ProductJPA> productJPAS = productRepository.findByNameIsLike(name);
        return productJPAS
                .stream()
                .map(jpa -> productMapper.mapToProduct(jpa))
                .toList();
    }

    @Override
    public Product findProductByID(long id) {
        Product product = productMapper.mapToProduct(productRepository.getProductById(id));
        return product;
    }
}

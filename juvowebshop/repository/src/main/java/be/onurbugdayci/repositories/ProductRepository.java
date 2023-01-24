package be.onurbugdayci.repositories;

import be.onurbugdayci.jpa.ProductJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductJPA,Long>{
    ProductJPA getProductById(long id);

    @Query("select p from ProductJPA p where upper(p.name) like concat('%',upper(:name),'%')")
    List<ProductJPA> findByNameIsLike(@Param("name") String name);
}

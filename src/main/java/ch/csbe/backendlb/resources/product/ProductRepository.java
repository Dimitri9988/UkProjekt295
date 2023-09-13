package ch.csbe.backendlb.resources.product;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface ProductRepository extends JpaRepository<ProductEntitie, Long> {

    @Query

    List<ProductEntitie> findProductEntitiesByName(String name);

    //List<ProductEntitie> saveProductEntitiesByName(String name);

    //List<ProductEntitie> updateProductEntitiesByName(String name);

    //List<ProductEntitie> deleteProductEntitiesByName(String name);


    ProductEntitie findProductEntitieById(Long id);






    //ProductEntitie saveProductEntitieById(Long id);

    //ProductEntitie updateProductEntitieById(Long id);

    //ProductEntitie deleteProductEntitieById(Long id);


}

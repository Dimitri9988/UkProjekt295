package ch.csbe.backendlb.resource.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//Inteagirt mit der Datenbank für die Prdukt Einträge
@Repository
@RepositoryRestResource(exported = false)
public interface ProductRepository extends JpaRepository<ProductEntitie, Long> {

    //Sucht anhand des Namens nach Produkten
    @Query
    List<ProductEntitie> findProductEntitiesByName(String name);

    //Sucht anahand der Id nach einem Produkt
    ProductEntitie findProductEntitieById(Long id);






}

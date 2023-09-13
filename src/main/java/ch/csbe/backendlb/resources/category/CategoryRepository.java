package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.user.UserEntitie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RepositoryRestResource(exported = false)
public interface CategoryRepository extends JpaRepository<CategoryEntities, Long> {

    //CategoryEntities updateCategoryEntitiesById(Long id);

    //CategoryEntities saveCategoryEntitiesById(Long id);

    CategoryEntities findCategoryEntitiesById(Long id);

    //CategoryEntities deleteCategoryEntitiesById(Long id);

    List<CategoryEntities> findCategoryEntitiesByName(String name);

    //List<CategoryEntities> saveCategoryEntitiessByName(String name);

    //List<CategoryEntities> updateCategoryEntitiessByName(String name);

    //List<CategoryEntities> deleteCategoryEntitiessByName(String name);

}

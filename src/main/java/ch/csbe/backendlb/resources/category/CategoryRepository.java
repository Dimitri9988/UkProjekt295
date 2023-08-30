package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.user.UserEntitie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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

package ch.csbe.backendlb.resource.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface CategoryRepository extends JpaRepository<CategoryEntities, Long> {

    // Sucht Kategory anhand des namen
    CategoryEntities findCategoryEntitiesByName(String name);

    //Sucht kategory anhand der Id
    CategoryEntities findCategoryEntitiesById(Long id);



}

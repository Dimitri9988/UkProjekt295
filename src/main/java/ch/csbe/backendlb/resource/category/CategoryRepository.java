package ch.csbe.backendlb.resource.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported = false)
public interface CategoryRepository extends JpaRepository<CategoryEntities, Long> {

    CategoryEntities findCategoryEntitiesByName(String name);

    CategoryEntities findCategoryEntitiesById(Long id);



}

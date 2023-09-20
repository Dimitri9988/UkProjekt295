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

    CategoryEntities findCategoryEntitiesByName(String name);

    CategoryEntities findCategoryEntitiesById(Long id);



}

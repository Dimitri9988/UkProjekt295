package ch.csbe.backendlb.resource.category;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.stereotype.Repository;

//Repository-Schnittstelle für die Kategorie-Entitäten.
@Repository
@RepositoryRestResource(exported = false)
public interface CategoryRepository extends JpaRepository<CategoryEntities, Long> {

    //Sucht eine Kategorie anhand des Namens
    CategoryEntities findCategoryEntitiesByName(String name);

    //Sucht eine Kategorie anhand der ID
    CategoryEntities findCategoryEntitiesById(Long id);

}

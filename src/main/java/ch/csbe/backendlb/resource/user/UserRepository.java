package ch.csbe.backendlb.resource.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//Inteagirt mit der Datenbank für die Benutzer Einträge
@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<UserEntitie, Long> {

    // Sucht anhand der Email einen Benutzer
    UserEntitie findUserEntitieByEmail(String email);

    // Sucht anhand der Id einen Benutzer
    UserEntitie findUserEntitieById(Long id);

    // Sucht anhand von benutzernamen ensprechende Benutzer
    List<UserEntitie> findUserEntitiesByUsername(String username);

    // Sucht anhand des vornamens Ensprechende Benutzer
    List<UserEntitie> findUserEntitiesByFirstName(String first_name);
}

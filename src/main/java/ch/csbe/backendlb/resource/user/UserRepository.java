package ch.csbe.backendlb.resource.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<UserEntitie, Long> {







    UserEntitie findUserEntitieByEmail(String email);

    //UserEntitie updateUserEntitieById(Long id);

    //UserEntitie saveUserEntitieById(Long id);

    UserEntitie findUserEntitieById(Long id);

    //UserEntitie deleteUserEntitieById(Long id);

    List<UserEntitie> findUserEntitiesByUsername(String username);

    //List<UserEntitie> saveUserEntitiesByUsername(String username);

    //List<UserEntitie> updateUserEntitiesByUsername(String username);

    //List<UserEntitie> deleteUserEntitiesByUsername(String username);

    List<UserEntitie> findUserEntitiesByFirstName(String first_name);

    //List<UserEntitie> saveUserEntitiesByUserFirstName(String first_name);

    //List<UserEntitie> updateUserEntitiesByFirstName(String first_name);

    //List<UserEntitie> deleteUserEntitiesByFirstName(String first_name);





}

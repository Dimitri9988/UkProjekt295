package ch.csbe.backendlb.resources.user;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;



    public List<UserEntitie> get() {
        return userRepository.findAll();
    }

    public UserEntitie getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserEntitie create(UserEntitie product) {
        return userRepository.save(product);
    }

    public UserEntitie update(Long id, UserEntitie user) {
        Optional<UserEntitie> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntitie existingUser = userOptional.get();
            existingUser.setId(user.getId());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setBirthday(user.getBirthday());
            return userRepository.save(existingUser);
        }
        return new UserEntitie();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);


    }
}



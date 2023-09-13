package ch.csbe.backendlb.resources.user;

import ch.csbe.backendlb.resources.product.productdto.ProductCreateDto;
import ch.csbe.backendlb.resources.product.productdto.ProductDetailDto;
import ch.csbe.backendlb.resources.user.userdto.UserCreateDto;
import ch.csbe.backendlb.resources.user.userdto.UserDetailDto;
import ch.csbe.backendlb.resources.user.userdto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;




    public List<UserEntitie> get() {
        return userRepository.findAll();
    }

    public UserDetailDto getById(Long id) {

        UserEntitie userEntitie = this.userRepository.getById(id);
        UserDetailDto userDetailDto = userMapper.toDetailDto(userEntitie);

        return userDetailDto;
    }

    public UserDetailDto create(UserCreateDto user) {
        return userMapper.toDetailDto(userRepository.save(userMapper.toEntity(user))) ;
    }



    public UserEntitie update(Long id, UserEntitie user) {
        Optional<UserEntitie> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntitie existingUser = userOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setBirthday(user.getBirthday());
            existingUser.setAuthenticated(user.getAuthenticated());
            return userRepository.save(existingUser);
        }
        return new UserEntitie();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);


    }
}



package ch.csbe.backendlb.resources.user;

import ch.csbe.backendlb.resources.login.LoginRequestDto;
import ch.csbe.backendlb.resources.user.userdto.UserCreateDto;
import ch.csbe.backendlb.resources.user.userdto.UserDetailDto;
import ch.csbe.backendlb.resources.user.userdto.UserMapper;
import ch.csbe.backendlb.resources.user.userdto.UserShowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


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

    public UserShowDto register(UserCreateDto userCreateDto) {
        UserEntitie userEntitie = userMapper.toEntity(userCreateDto);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode( userCreateDto.getPassword());

        userEntitie.setPassword(hashedPassword);
        userRepository.save(userEntitie);
        return userMapper.toShowDto(userEntitie);
    }
    public UserEntitie findUserByEmail(String email) {
        UserEntitie userEntitie = this.userRepository.findUserEntitieByEmail(email);

        return userEntitie;
    }
    public UserEntitie getUserWithCredentials(LoginRequestDto loginRequestDto) {
        UserEntitie userEntitie = findUserByEmail(loginRequestDto.getEmail());
        if(userEntitie != null) {
            boolean isPasswordMatch = encoder.matches(loginRequestDto.getPassword(), userEntitie.getPassword());
            if(isPasswordMatch) {
                return userEntitie;
            }
        }

        return null;
    }
}



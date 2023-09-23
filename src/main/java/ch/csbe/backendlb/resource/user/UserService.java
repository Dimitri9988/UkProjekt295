package ch.csbe.backendlb.resource.user;

import ch.csbe.backendlb.resource.login_regist.LoginRequestDto;
import ch.csbe.backendlb.resource.user.userdto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Ist verantwortlich für die Logikt für die Benutzer
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Gibt alle Benutzer zurück
    public List<UserEntitie> get() {
        return userRepository.findAll();
    }

    public UserDetailDto getById(Long id) {

        UserEntitie userEntitie = this.userRepository.getById(id);
        UserDetailDto userDetailDto = userMapper.toDetailDto(userEntitie);

        return userDetailDto;
    }

    // Gibt Benutzer Details zurück anhand der Id
    public UserDetailDto create(UserCreateDto user) {
        return userMapper.toDetailDto(userRepository.save(userMapper.toEntity(user))) ;
    }


    // aktualisiert ein Benutzer anhand der Id mit den mitgegebenen Daten
    public UserDetailDto update(Long id, UserUpdateDto user) {
        Optional<UserEntitie> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntitie existingUser = userOptional.get();
            userMapper.update(user, existingUser);

            return userMapper.toDetailDto(userRepository.save(existingUser));
        }
        return userMapper.toDetailDto(new UserEntitie());
    }

    // Löscht ein Benutzer anhand der Id
    public void deleteById(Long id) {
        userRepository.deleteById(id);


    }

    // Registrirt einen neuen Benutzer
    public UserShowDto register(UserCreateDto userCreateDto) {
        UserEntitie userEntitie = userMapper.toEntity(userCreateDto);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode( userCreateDto.getPassword());

        userEntitie.setPassword(hashedPassword);
        userRepository.save(userEntitie);
        return userMapper.toShowDto(userEntitie);
    }

    // Sucht einen Benutzer anhand der Email
    public UserEntitie findUserByEmail(String email) {
        UserEntitie userEntitie = this.userRepository.findUserEntitieByEmail(email);

        return userEntitie;
    }

    // Überprüft die Anmelde Infos eines Benutzer und gibt sin zurück wen sie übereinstimmen.
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



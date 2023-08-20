package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.UserCharity;
import pl.coderslab.charity.entity.UserToRegister;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;



    public void saveNew(UserToRegister userToRegister) {
        if (userRepository.existsByUsername(userToRegister.getUsername())) {
            throw new DuplicateKeyException("użytkownik o podanej nazwie już istnieje");
        }
        UserCharity userCharity =new UserCharity();
        userCharity.setEnabled(1);
        userCharity.setUsername(userToRegister.getUsername());
        userCharity.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER");
        userCharity.setRoles(new HashSet<>(Arrays.asList(role)));
        userCharity.setName(userToRegister.getName());
        userCharity.setLastName(userToRegister.getLastName());
        userRepository.save(userCharity);
    }

    public void save(UserCharity userCharity){
        userRepository.save(userCharity);
    }

    public List<UserCharity> adminsList(){
        Role adminRole=roleRepository.findByName("ROLE_ADMIN");
        return userRepository.findAllByRolesEquals(adminRole);
    }

    public UserCharity findById(Long id){
        return userRepository.findById(id).get();
    }

    public void delete(UserCharity userCharity){
        userCharity.setRoles(null);
        userRepository.delete(userCharity);
    }

    public void deleteAdmin(UserCharity userCharity){
        Role userRole = roleRepository.findByName("ROLE_USER");
        userCharity.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(userCharity);
    }

    public List<UserCharity> findAllUsers(){
        Role userRole = roleRepository.findByName("ROLE_USER");
        return userRepository.findAllByRolesEquals(userRole);
    }

    public UserToRegister checkUser(UserToRegister userToRegister){
        if (userRepository.existsByUsername(userToRegister.getUsername())) {
            throw new DuplicateKeyException("użytkownik o podanej nazwie już istnieje");
        }
        else return userToRegister;
    }

    public UserCharity findByUsername(String username){
        return userRepository.findByUsername(username).get();
    }
}

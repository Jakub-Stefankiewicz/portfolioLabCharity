package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(User user){
        if(userRepository.existsAllByUsername(user.getUsername())){
            //uwaga- zrobić walidację, na razie wywala exceptiona
            throw new DuplicateKeyException("użytkownik o podanej nazwie już istnieje");
        } else {
            user.setEnabled(1);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Role role=roleRepository.findByName("ROLE_USER");
            user.setRoles(new HashSet<>(Arrays.asList(role)));
            userRepository.save(user);
        }
    }
}

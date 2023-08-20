package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.UserCharity;
import pl.coderslab.charity.repository.UserRepository;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserCharity userCharity = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));

        final Collection<? extends GrantedAuthority> authorities =
                userCharity
                        .getRoles()
                        .stream()
                        .map(Role::getName)
                        .map(SimpleGrantedAuthority::new)
                        .toList();

        return new User(userCharity.getUsername(), userCharity.getPassword(), authorities);
    }
}

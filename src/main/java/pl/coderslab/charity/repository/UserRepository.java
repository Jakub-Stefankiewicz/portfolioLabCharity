package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.UserCharity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserCharity, Long> {

    boolean existsByUsername(String login);

    Optional<UserCharity> findByUsername(String username);

    List<UserCharity> findAllByRolesEquals(Role role);
}

package net.usermd.jrkn87.repositories;

import net.usermd.jrkn87.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNick(String nick);
}

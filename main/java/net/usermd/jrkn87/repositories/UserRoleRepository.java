package net.usermd.jrkn87.repositories;

import net.usermd.jrkn87.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}

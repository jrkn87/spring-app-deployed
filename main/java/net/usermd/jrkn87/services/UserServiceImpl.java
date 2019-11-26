package net.usermd.jrkn87.services;

import net.usermd.jrkn87.models.User;
import net.usermd.jrkn87.models.UserRole;
import net.usermd.jrkn87.repositories.UserRepository;
import net.usermd.jrkn87.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByNick(username);
    }

    public void addDefaultUserRole(User user) {
        UserRole byRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(byRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }
}

package net.usermd.jrkn87.services;

import net.usermd.jrkn87.models.User;

public interface UserService {
    public User findByUsername(String username);
    public void addDefaultUserRole(User user);
}

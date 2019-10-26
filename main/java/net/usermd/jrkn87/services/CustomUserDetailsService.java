package net.usermd.jrkn87.services;

import net.usermd.jrkn87.models.User;
import net.usermd.jrkn87.models.UserRole;
import net.usermd.jrkn87.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byNick = userRepository.findByNick(s);
        if (byNick == null)
            throw new UsernameNotFoundException("Nick not found!");
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
          byNick.getNick(),
          byNick.getPassword(),
          convertAuthorities(byNick.getRoles())
        );
        return userDetails;
    }

    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserRole ur : roles) {
            authorities.add(new SimpleGrantedAuthority(ur.getRole()));
        }
        return authorities;
    }
}

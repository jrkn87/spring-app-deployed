package net.usermd.jrkn87.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable {
   private static final long serialVersionUID = -3651L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotEmpty
   private String firstName;
   private String lastName;
   @NotEmpty
   private String nick;
   @NotEmpty
   private String password;
   @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
   private Set<UserRole> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastNAme='" + lastName + '\'' +
                ", nick='" + nick + '\'' +
                ", roles=" + roles +
                '}';
    }
}

package net.usermd.jrkn87.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
   @NotEmpty(message = "{net.usermd.jrkn87.models.user.firstName.NotEmpty}")
   private String firstName;
   private String lastName;
   @Column(unique = true)
   @NotEmpty(message = "{net.usermd.jrkn87.models.user.nick.NotEmpty}")
   private String nick;
   @NotEmpty(message = "{net.usermd.jrkn87.models.user.password.NotEmpty}")
   private String password;
   @NotEmpty(message = "{net.usermd.jrkn87.models.user.email.NotEmpty}")
   @Email(message = "{net.usermd.jrkn87.models.user.email.Email}")
   private String email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
                ", lastName='" + lastName + '\'' +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}

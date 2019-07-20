package net.usermd.jrkn87.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Consumer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    private int nip;

    public Consumer() {}

    public Consumer(String firstName, String lastName, int nip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nip = nip;
    }

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

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nip=" + nip +
                '}';
    }
}

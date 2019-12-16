package net.usermd.jrkn87.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{net.usermd.jrkn87.models.Client.clientName.NotEmpty}")
    @Size(min = 3, message = "{net.usermd.jrkn87.models.Client.clientName.Size}")
    private String clientName;
    @Pattern(regexp = "\\d{9}", message = "{net.usermd.jrkn87.models.Client.phoneNumer.Pattern}")
    private String phoneNumber;
    private String email;
    private long nip;
    @NotEmpty(message = "{net.usermd.jrkn87.models.Client.advertising.NotEmpty}")
    private String advertising;

    public Client() {}

    public Client(@NotEmpty(message = "{net.usermd.jrkn87.models.Client.clientName.NotEmpty}") @Size(min = 3, message = "{net.usermd.jrkn87.models.Client.clientName.Size}") String clientName, @Pattern(regexp = "\\d{9}", message = "{net.usermd.jrkn87.models.Client.phoneNumer.Pattern}") String phoneNumber, String email, int nip, @NotEmpty(message = "{net.usermd.jrkn87.models.Client.advertising.NotEmpty}") String advertising) {
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nip = nip;
        this.advertising = advertising;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNip() {
        return nip;
    }

    public void setNip(long nip) {
        this.nip = nip;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", nip=" + nip +
                ", advertising='" + advertising + '\'' +
                '}';
    }
}

package net.usermd.jrkn87.models;

import net.usermd.jrkn87.utils.Status;
import net.usermd.jrkn87.utils.WarrantyStatus;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.*;

@Entity
public class Complaint implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status status;
    private LocalDate startDate;
    private LocalDate pushServiceDate;
    private LocalDate pullServiceDate;
    private LocalDate pickupDate;
    private int durationTimeOnDays;
    private int durationTimeOnDaysInService;
    @NotEmpty(message = "{net.usermd.jrkn87.models.Complaint.description.NotEmpty}")
    @Size(min = 10, message = "{net.usermd.jrkn87.models.Complaint.description.Size}")
    private String description;
    private String additionalDescription;
    private String result;
    private String decision;
    private String pickupWay;
    private String comment;
    private boolean isArchive;
    private WarrantyStatus warranty;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Valid
    private Client client;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Valid
    private Product product;

    public Complaint() {
        this.status = Status.NOWA;
        this.startDate = LocalDate.now();
        this.pushServiceDate = null;
        this.pullServiceDate = null;
        this.pickupDate = null;
        this.durationTimeOnDays = 0;
        this.durationTimeOnDaysInService = 0;
        this.comment = null;
        this.isArchive = false;
        this.description = null;
        this.additionalDescription = null;
        this.result = null;
        this.decision = null;
        this.pickupWay = null;
        this.client = null;
        this.product = null;
    }

    public Complaint(LocalDate startDate, LocalDate pushServiceDate, LocalDate pullServiceDate, LocalDate pickupDate, int durationTimeOnDays, int durationTimeOnDaysInService, String comment, boolean isArchive, String description, String additionalDescription, String result, String decision, String pickupWay, Client client, Product product) {
        this.startDate = startDate;
        this.pushServiceDate = pushServiceDate;
        this.pullServiceDate = pullServiceDate;
        this.pickupDate = pickupDate;
        this.durationTimeOnDays = durationTimeOnDays;
        this.durationTimeOnDaysInService = durationTimeOnDaysInService;
        this.comment = comment;
        this.isArchive = isArchive;
        this.description = description;
        this.additionalDescription = additionalDescription;
        this.result = result;
        this.decision = decision;
        this.pickupWay = pickupWay;
        this.client = client;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate() {
        this.startDate = startDate;
    }

    public LocalDate getPushServiceDate() {
        return pushServiceDate;
    }

    public void setPushServiceDate() {
        this.pushServiceDate = LocalDate.now();
    }

    public LocalDate getPullServiceDate() {
        return pullServiceDate;
    }

    public void setPullServiceDate() {
        this.pullServiceDate = LocalDate.now();
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate() {
        this.pickupDate = LocalDate.now();
    }

    public int getDurationTimeOnDays() {
        return durationTimeOnDays;
    }

    public void setDurationTimeOnDays(int durationTimeOnDays) {
        this.durationTimeOnDays = durationTimeOnDays;
    }

    public int getDurationTimeOnDaysInService() {
        return durationTimeOnDaysInService;
    }

    public void setDurationTimeOnDaysInService(int durationTimeOnDaysInService) {
        this.durationTimeOnDaysInService = durationTimeOnDaysInService;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isArchive() {
        return isArchive;
    }

    public void setArchive(boolean archive) {
        isArchive = archive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public void setAdditionalDescription(String additionalDescription) {
        this.additionalDescription = additionalDescription;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getPickupWay() {
        return pickupWay;
    }

    public void setPickupWay(String pickupWay) {
        this.pickupWay = pickupWay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public WarrantyStatus getWarranty() {
        return warranty;
    }

    public void setWarranty(WarrantyStatus warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", status=" + status +
                ", startDate=" + startDate +
                ", pushServiceDate=" + pushServiceDate +
                ", pullServiceDate=" + pullServiceDate +
                ", pickupDate=" + pickupDate +
                ", durationTimeOnDays=" + durationTimeOnDays +
                ", durationTimeOnDaysInService=" + durationTimeOnDaysInService +
                ", description='" + description + '\'' +
                ", additionalDescription='" + additionalDescription + '\'' +
                ", result='" + result + '\'' +
                ", decision='" + decision + '\'' +
                ", pickupWay='" + pickupWay + '\'' +
                ", comment='" + comment + '\'' +
                ", isArchive=" + isArchive +
                ", warranty=" + warranty +
                ", client=" + client +
                ", product=" + product +
                '}';
    }
}

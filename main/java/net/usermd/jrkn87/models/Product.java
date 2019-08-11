package net.usermd.jrkn87.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private static final long serilaVersionUID = -16498752167L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String productName;
    @NotNull
    private String producer;
    @NotNull
    private int serialNumber;

    public Product() {}

    public Product(@NotNull String productName, @NotNull String producer, @NotNull int serialNumber) {
        this.productName = productName;
        this.producer = producer;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public static long getSerilaVersionUID() {
        return serilaVersionUID;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }
}

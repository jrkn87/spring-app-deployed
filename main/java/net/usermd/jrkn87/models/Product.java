package net.usermd.jrkn87.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private static final long serilaVersionUID = -16498752167L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{net.usermd.jrkn87.models.Product.productName.NotEmpty}")
    @Size(min = 3, message = "{net.usermd.jrkn87.models.Product.productName.Size}")
    private String productName;
    @NotEmpty(message = "{net.usermd.jrkn87.models.Product.producer.NotEmpty}")
    private String producer;
    @NotEmpty(message = "{net.usermd.jrkn87.models.Product.serialNumber.NotEmpty}")
    private String  serialNumber;
    private String deviceStatus;

    public Product() {}

    public Product(@NotEmpty(message = "{net.usermd.jrkn87.models.Product.productName.NotEmpty}") @Size(min = 3, message = "{net.usermd.jrkn87.models.Product.productName.Size}") String productName, @NotEmpty(message = "{net.usermd.jrkn87.models.Product.producer.NotEmpty}") String producer, @NotEmpty(message = "{net.usermd.jrkn87.models.Product.serialNumber.NotEmpty}") String serialNumber, String deviceStatus) {
        this.productName = productName;
        this.producer = producer;
        this.serialNumber = serialNumber;
        this.deviceStatus = deviceStatus;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public static long getSerilaVersionUID() {
        return serilaVersionUID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                '}';
    }
}

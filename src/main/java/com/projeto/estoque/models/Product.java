package com.projeto.estoque.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;

    @Column(nullable = false, length = 80)
    @NotNull
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @NotNull
    private double quantity;

    @Column(nullable = false)
    @NotNull
    private String property;

    @Column(nullable = false)
    @NotNull
    private BigDecimal value;

    @Column(nullable = false)
    @NotNull
    private Date fabrication;

    @Column(nullable = false)
    @NotNull
    private Date validity;

    public Product(Long idProduct, String name, String description, double quantity, String property, BigDecimal value, Date fabrication, Date validity) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.property = property;
        this.value = value;
        this.fabrication = fabrication;
        this.validity = validity;
    }

    public Product() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getFabrication() {
        return fabrication;
    }

    public void setFabrication(Date fabrication) {
        this.fabrication = fabrication;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.quantity, quantity) == 0 && Objects.equals(idProduct, product.idProduct) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(property, product.property) && Objects.equals(value, product.value) && Objects.equals(fabrication, product.fabrication) && Objects.equals(validity, product.validity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, description, quantity, property, value, fabrication, validity);
    }
}

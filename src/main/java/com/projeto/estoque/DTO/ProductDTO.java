package com.projeto.estoque.DTO;

import com.projeto.estoque.models.Product;
import com.projeto.estoque.models.User;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDTO {
    private String name;
    private String description;
    private double quantity;
    private String property;
    private BigDecimal value;
    private Date fabrication;
    private Date validity;


    public ProductDTO convert(Product product){
        BeanUtils.copyProperties(product, this, "id");
        return this;
    }

    public List<ProductDTO> convertList(List<Product> productList){
        ProductDTO productDTO = new ProductDTO();
        List<ProductDTO> productDTOList= new ArrayList<>();
        productList.forEach(product -> {
            productDTOList.add(productDTO.convert(product));
        });
        return productDTOList;
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
}

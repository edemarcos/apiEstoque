package com.projeto.estoque.controllers;

import com.projeto.estoque.DTO.ProductDTO;
import com.projeto.estoque.models.Product;
import com.projeto.estoque.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductServices services;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> findById(@PathVariable(value = "id") Long id) {
        ProductDTO productDTO = services.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> productDTOList = services.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductDTO productDTOrequest) {
        Product productModel = new Product();
        BeanUtils.copyProperties(productDTOrequest, productModel);
        ProductDTO productDTO = services.save(productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductDTO productRequest) {
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        product.setIdProduct(id);
        ProductDTO productConvert = services.update(product, id);
        return ResponseEntity.status(HttpStatus.OK).body(productConvert);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }
}

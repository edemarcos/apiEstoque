
package com.projeto.estoque.services;

import com.projeto.estoque.DTO.ProductDTO;
import com.projeto.estoque.models.Product;
import com.projeto.estoque.repositories.ProductRepository;
import com.projeto.estoque.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    ProductRepository repository;

    public List<ProductDTO> findAll() {
        ProductDTO productDTO = new ProductDTO();
        return productDTO.convertList(repository.findAll());
    }

    public ProductDTO findById(Long id){
        Product product = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Id not found " + id));
        ProductDTO productDTO = new ProductDTO();
        return productDTO.convert(product);
    }

    public ProductDTO save(Product product) {
        ProductDTO productDTO = new ProductDTO();
        Product productRepo = repository.save(product);
        return productDTO.convert(productRepo);
    }

    public ProductDTO update(Product product, Long id){
        ProductDTO productDTO = new ProductDTO();
        Product entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No records found for this ID!"));

        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setQuantity(product.getQuantity());

        return productDTO.convert(repository.save(entity));
    }

    public void delete(Long id){
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}

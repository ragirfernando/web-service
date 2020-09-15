package com.webservice.webservice.service;

import com.webservice.webservice.domain.Product;
import com.webservice.webservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
}

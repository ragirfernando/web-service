package com.webservice.webservice.service;

import com.webservice.webservice.domain.Category;
import com.webservice.webservice.domain.Order;
import com.webservice.webservice.repository.CategoryRepository;
import com.webservice.webservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Integer id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}

package com.webservice.webservice.service;

import com.webservice.webservice.domain.Order;
import com.webservice.webservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Integer id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}

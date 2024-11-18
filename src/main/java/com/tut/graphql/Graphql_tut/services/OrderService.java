package com.tut.graphql.Graphql_tut.services;

import com.tut.graphql.Graphql_tut.entity.Order;
import com.tut.graphql.Graphql_tut.entity.User;
import com.tut.graphql.Graphql_tut.exceptions.ResourceNotFoundException;
import com.tut.graphql.Graphql_tut.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public Order getOrder(int orderId){
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));

        return order;
    }

    public boolean deleteOrder(int orderId){
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        orderRepo.delete(order);
        return true;
    }
}

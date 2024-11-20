package com.tut.graphql.Graphql_tut.controller;

import com.tut.graphql.Graphql_tut.entity.Order;
import com.tut.graphql.Graphql_tut.entity.User;
import com.tut.graphql.Graphql_tut.services.OrderService;
import com.tut.graphql.Graphql_tut.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private UserService userService;
    private OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @MutationMapping
    public Order createOrder(@Argument String orderDetail, @Argument String address,
                             @Argument int price, @Argument int userId){

        User user = userService.getUser(userId);

        Order order = new Order();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);

        return orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return orderService.getOrder(orderId);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument int orderId){
        return orderService.deleteOrder(orderId);
    }
}

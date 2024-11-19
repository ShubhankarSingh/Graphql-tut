package com.tut.graphql.Graphql_tut.controller;

import com.tut.graphql.Graphql_tut.entity.User;
import com.tut.graphql.Graphql_tut.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Specify name here if mutation name doesn't match with function name
    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone,
                           @Argument String email, @Argument String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument int userId){
        return userService.getUser(userId);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }

}

package com.tut.graphql.Graphql_tut.services;

import com.tut.graphql.Graphql_tut.entity.User;
import com.tut.graphql.Graphql_tut.exceptions.ResourceNotFoundException;
import com.tut.graphql.Graphql_tut.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUser(int userId){
      User user = userRepo.findById(userId)
              .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));

      return user;
    }

    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        userRepo.delete(user);

        return true;
    }

}

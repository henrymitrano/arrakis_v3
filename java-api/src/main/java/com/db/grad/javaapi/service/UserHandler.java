package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHandler implements UserService {
    public List<User> getAllUsers(){

    }

    public User addUser(User theUser){
    }

    public long getNoOfUsers(){

    }

    public boolean removeUser(String username){

    }

    public User getUserByUsername(String username){

    }


}
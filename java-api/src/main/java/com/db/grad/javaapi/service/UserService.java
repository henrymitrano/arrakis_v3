package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    public List<User> getAllUsers();

    public User addUser(User theUser);

    public long getNoOfUsers();

    public boolean removeUser(long uniqueId);

    public User getUserByUsername(User name);
    public User getUserById(long uniqueId);


}
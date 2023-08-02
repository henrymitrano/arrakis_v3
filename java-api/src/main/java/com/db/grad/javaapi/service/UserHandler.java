package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserHandler implements UserService {

    private UsersRepository itsUsersRepo;

    @Autowired
    public UserHandler( UsersRepository userRepo )
    {
        itsUsersRepo = userRepo;
    }
    public List<User> getAllUsers(){
        return itsUsersRepo.findAll();
    }

    public User addUser(User theUser){
        return itsUsersRepo.save(theUser);

    }

    public long getNoOfUsers(){
        return itsUsersRepo.count();
    }

    public boolean removeUser(long uniqueId){
        boolean result = false;

        Optional<User> theUser = itsUsersRepo.findById(uniqueId);
        if(theUser.isPresent())
        {
            itsUsersRepo.delete(theUser.get());
            result = true;
        }

        return  result;
    }


    public User getUserByUsername(User name){
        User userToFind = new User();
        userToFind.setUsername(name.getUsername());
        List<User> users = itsUsersRepo.findByUsername(userToFind);
        User result = null;

        if( users.size() == 1)
            result = users.get(0);

        return result;
    }
    public User getUserById(long uniqueId){
        return itsUsersRepo.findById(uniqueId).get();
    }



}
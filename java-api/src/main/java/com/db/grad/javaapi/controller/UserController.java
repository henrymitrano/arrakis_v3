package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private UserHandler UserService;

    @Autowired
    public UserController(UserHandler ds)
    {
        UserService = ds;
    }

    @GetMapping("/users")
    public List<User> getAllDogs() {
        return UserService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity< User > getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        User users = UserService.getUserById(id);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return UserService.addUser(user);
    }


    @DeleteMapping("/users/{id}")
    public Map< String, Boolean > deleteUser(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = UserService.removeUser(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
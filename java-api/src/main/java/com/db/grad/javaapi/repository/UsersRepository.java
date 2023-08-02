package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository <User, Long>
{
    User findByIsin(int isin);
    List<User> findByUsername(User name);

}
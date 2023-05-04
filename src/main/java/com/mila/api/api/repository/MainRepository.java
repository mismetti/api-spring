package com.mila.api.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mila.api.api.model.User;

@Repository
public interface MainRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    User findById(int id);

    List<User> findByName(String name);

    List<User> findByOrderByName();


    
}

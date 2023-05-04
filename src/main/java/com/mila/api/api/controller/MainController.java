package com.mila.api.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mila.api.api.model.User;
import com.mila.api.api.repository.MainRepository;

@RestController
public class MainController {

    @Autowired
    private MainRepository action;

    @PostMapping("/api")
    public User create(@RequestBody User userObject){
        return action.save(userObject);
    }

    @GetMapping("/api")
    public List<User> search(){

        return action.findAll();
    }

    @GetMapping("/api/{id}")
    public User selectFromCode(@PathVariable int id){
        return action.findById(id);
    }

    @GetMapping("/api/count")
    public long count(){
        return action.count();
    }
    
    @GetMapping("/api/orderName")
    public List<User> orderName(){

        return action.findByOrderByName();

    }

    @GetMapping("/api/name/{name}")
    public List<User> selectFromCode(@PathVariable String name){
        return action.findByName(name);
    }

    @PutMapping("/api")
    public User change(@RequestBody User objUser){
        return action.save(objUser);
    }

    @DeleteMapping("/api/{id}")
    public void delete(@PathVariable int id){
        User userObj = selectFromCode(id);
        action.delete(userObj); 
    }

    @GetMapping("/")
    public String mensagem(){
        return "hello world";
    }

    @GetMapping("/amigo/{name}")
    public String amigo(@PathVariable String name){
        return "voce e um amigo amigo"+ name;
    }

    @PostMapping("/user")
    public User user(@RequestBody User u){

        return u;
    }

}

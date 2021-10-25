package com.example.speakersapp.controllers;


import com.example.speakersapp.model.User;
import com.example.speakersapp.repo.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class User_Controllers {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @RequestMapping("/usersList")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public User get (@PathVariable Long id){
        return userRepository.getById(id);
    }

    @PostMapping
    @RequestMapping("/addUser")
    public User createUser(@RequestBody final User user){
        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user){
        User existingSession = userRepository.getById(id);
        BeanUtils.copyProperties(user,existingSession,"user_id");
        return userRepository.saveAndFlush(existingSession);
    }
}

package com.example.speakersapp.controllers;

import com.example.speakersapp.model.user_exercise;
import com.example.speakersapp.repo.user_exercise_repo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/userExercise")
public class User_Exercise_Controllers {

    @Autowired
    private user_exercise_repo user_exercise_repo;

    @GetMapping
    @RequestMapping("/List")
    public List<user_exercise> list(){
        return user_exercise_repo.findAll();
    }

    @GetMapping
    @RequestMapping("/List/{id}")
    public user_exercise get (@PathVariable Long id){
        return user_exercise_repo.getById(id);
    }

    @PostMapping
    @RequestMapping("/Add")
    public user_exercise createUser(@RequestBody final user_exercise User_exercise){
        return user_exercise_repo.saveAndFlush(User_exercise);
    }

    @DeleteMapping
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        user_exercise_repo.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "update/{id}",method = RequestMethod.PUT)
    public user_exercise update(@PathVariable Long id, @RequestBody user_exercise User_exercise){
        user_exercise existingUser_exercise = user_exercise_repo.getById(id);
        BeanUtils.copyProperties(User_exercise,existingUser_exercise,"id_exe");
        return user_exercise_repo.saveAndFlush(existingUser_exercise);
    }
}

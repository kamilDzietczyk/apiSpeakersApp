package com.example.speakersapp.controllers;

import com.example.speakersapp.model.Exercises;
import com.example.speakersapp.model.User;
import com.example.speakersapp.repo.EexercisesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exercises")
public class Exercises_Controllers {

    @Autowired
    private EexercisesRepository exercisesRepository;

    @GetMapping
    @RequestMapping("/ExerciseList")
    public List<Exercises> getlistExercise(){
        return exercisesRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/Exercise/{id}")
    public Exercises getExercise (@PathVariable Long id){
        return exercisesRepository.getById(id);
    }

    @PostMapping
    @RequestMapping("/addExercise")
    public Exercises createExercises(@RequestBody final Exercises exercises){
        return exercisesRepository.saveAndFlush(exercises);
    }

    @DeleteMapping
    @RequestMapping(value = "deleteExercise/{id}", method = RequestMethod.DELETE)
    public void deleteExercise(@PathVariable Long id){
        exercisesRepository.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "updateExercise/{id}",method = RequestMethod.PUT)
    public Exercises updateExercise(@PathVariable Long id, @RequestBody Exercises exercises){
        Exercises existingExercises = exercisesRepository.getById(id);
        BeanUtils.copyProperties(exercises,existingExercises,"exercises_id");
        return exercisesRepository.saveAndFlush(existingExercises);
    }
}

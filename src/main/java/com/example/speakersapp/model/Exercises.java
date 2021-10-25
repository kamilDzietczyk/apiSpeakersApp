package com.example.speakersapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "exercises")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long exercises_id;
    String exercises_name;
    String exercises_char;

    @ManyToMany(mappedBy = "exercises")
    @JsonIgnore
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getExercises_char() {
        return exercises_char;
    }

    public void setExercises_char(String exercises_char) {
        this.exercises_char = exercises_char;
    }

    public Long getExercises_id() {
        return exercises_id;
    }

    public void setExercises_id(Long exercises_id) {
        this.exercises_id = exercises_id;
    }

    public String getExercises_name() {
        return exercises_name;
    }

    public void setExercises_name(String exercises_name) {
        this.exercises_name = exercises_name;
    }
}

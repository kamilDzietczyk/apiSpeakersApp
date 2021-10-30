package com.example.speakersapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user_exercise")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class user_exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_exe;
    private Long user_id;
    private Long exercises_id;

    public Long getId_exe() {
        return id_exe;
    }

    public void setId_exe(Long id_exe) {
        this.id_exe = id_exe;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getExercises_id() {
        return exercises_id;
    }

    public void setExercises_id(Long exercises_id) {
        this.exercises_id = exercises_id;
    }
}

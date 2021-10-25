package com.example.speakersapp.repo;

import com.example.speakersapp.model.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EexercisesRepository extends JpaRepository<Exercises,Long> {
}

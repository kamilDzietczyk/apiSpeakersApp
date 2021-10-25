package com.example.speakersapp.repo;

import com.example.speakersapp.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository extends JpaRepository<Records,Long> {
}

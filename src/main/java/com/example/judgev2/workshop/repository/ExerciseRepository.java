package com.example.judgev2.workshop.repository;

import com.example.judgev2.workshop.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT e.name FROM Exercise e " + "ORDER BY e.name")
    List<String> findAllExercises();

    Exercise findByName(String name);
}

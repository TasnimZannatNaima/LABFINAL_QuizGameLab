package com.it22001.quizGameLab.repository;

import com.it22001.quizGameLab.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> { }

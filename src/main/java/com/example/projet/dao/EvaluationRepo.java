package com.example.projet.dao;

import com.example.projet.entities.Evaluation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepo extends JpaRepository<Evaluation,Long> {
}

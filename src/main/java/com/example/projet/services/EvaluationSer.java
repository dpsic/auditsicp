package com.example.projet.services;

import java.util.List;

import com.example.projet.entities.Evaluation;

public interface EvaluationSer {
    Evaluation save(Evaluation eval);
    Evaluation getByID(Long id);
    List<Evaluation> getAll();
}

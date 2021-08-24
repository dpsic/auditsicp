package com.example.projet.dao;

import java.util.List;

import com.example.projet.entities.Evaluation;
import com.example.projet.entities.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultatRepo extends JpaRepository<Resultat,Long> {
    List<Resultat> findByEvaluation(Evaluation evaluation);
}

package com.example.projet.dao;

import java.util.List;

import com.example.projet.entities.Aspect;
import com.example.projet.entities.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommandationRepo extends JpaRepository<Recommandation, Long> {
    Recommandation findByReference(String reference);
    List<Recommandation> findByAspect(Aspect aspect);
}

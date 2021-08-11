package com.example.projet.dao;

import com.example.projet.entities.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommandationRepo extends JpaRepository<Recommandation, Long> {
    Recommandation findByReference(String reference);
}

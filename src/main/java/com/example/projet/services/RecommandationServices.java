package com.example.projet.services;

import java.util.List;

import com.example.projet.entities.Recommandation;

public interface RecommandationServices {
    Recommandation save(Recommandation recommandation);

    Recommandation findByReference(String ref);
    List<Recommandation> findByAspect(Long idAspect);
}

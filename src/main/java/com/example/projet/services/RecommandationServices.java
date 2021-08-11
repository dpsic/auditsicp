package com.example.projet.services;

import com.example.projet.entities.Recommandation;

public interface RecommandationServices {
    Recommandation save(Recommandation recommandation);

    Recommandation findByReference(String ref);
}

package com.example.projet.services;

import java.util.List;

import com.example.projet.entities.Resultat;

public interface ResultatServices {
    Resultat save(Resultat resultat);
    List<Resultat> findByEvaluation(Long eva);

}

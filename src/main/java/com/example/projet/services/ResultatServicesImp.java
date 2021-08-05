package com.example.projet.services;

import com.example.projet.dao.ResultatRepo;
import com.example.projet.entities.Resultat;
import com.example.projet.exceptions.LibbeleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultatServicesImp implements ResultatServices{
    @Autowired
    ResultatRepo resultatRepo;
    @Override
    public Resultat save(Resultat resultat) {
        try{
            return resultatRepo.save(resultat);
        }
        catch(Exception ex)

        {
            throw new LibbeleException("Erreur Fatale");
        }}
}


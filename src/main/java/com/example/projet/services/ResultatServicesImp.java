package com.example.projet.services;

import java.util.List;

import com.example.projet.dao.ResultatRepo;
import com.example.projet.entities.Evaluation;
import com.example.projet.entities.Resultat;
import com.example.projet.exceptions.LibbeleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultatServicesImp implements ResultatServices{
    @Autowired
    ResultatRepo resultatRepo;
    @Autowired
    EvaluationSer evaluationSer;
    @Override
    public Resultat save(Resultat resultat) {
        try{
            return resultatRepo.save(resultat);
        }
        catch(Exception ex)

        {
            throw new LibbeleException("Erreur Fatale");
        }}
    @Override
    public List<Resultat> findByEvaluation(Long eva) {
        Evaluation evaluation = evaluationSer.getByID(eva);
        // TODO Auto-generated method stub
        return resultatRepo.findByEvaluation(evaluation);
    }
}


package com.example.projet.services;

import com.example.projet.dao.EvaluationRepo;
import com.example.projet.entities.Evaluation;
import com.example.projet.exceptions.LibbeleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationServImp implements EvaluationSer{
@Autowired
    EvaluationRepo evaluationRepo;
    @Override
    public Evaluation save(Evaluation eval) {
        try{
        return evaluationRepo.save(eval);
    }
        catch(Exception ex)

    {
        throw new LibbeleException("Erreur Fatale");
    }}
}

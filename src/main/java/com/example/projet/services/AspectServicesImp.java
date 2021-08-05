package com.example.projet.services;

import com.example.projet.dao.AspectRepo;
import com.example.projet.dao.EvaluationRepo;
import com.example.projet.entities.Aspect;
import com.example.projet.entities.Evaluation;
import com.example.projet.exceptions.LibbeleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AspectServicesImp implements AspectServices{
    @Autowired
       AspectRepo aspectRepo;
        @Override
        public Aspect save(Aspect asp) {
            try{
                return aspectRepo.save(asp);
            }
            catch(Exception ex)

            {
                throw new LibbeleException("Erreur Fatale");
            }}
    }

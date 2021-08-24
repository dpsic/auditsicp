package com.example.projet.services;

import java.util.List;

import com.example.projet.dao.EvaluationRepo;
import com.example.projet.entities.Evaluation;
import com.example.projet.exceptions.LibbeleException;
import com.example.projet.feign.OrganeRestClient;
import com.example.projet.feign.PersonnelRestClient;
import com.example.projet.modals.Organe;
import com.example.projet.modals.Personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationServImp implements EvaluationSer{
@Autowired
    EvaluationRepo evaluationRepo;

    @Autowired
    OrganeRestClient oRestClient;
    @Autowired
    PersonnelRestClient pRestClient;
    @Override
    public Evaluation save(Evaluation eval) {
        try{
           eval.setEvaluateurID(eval.getPersonnel().getId()); 
           eval.setOrganeID(eval.getOrgane().getId());
            return evaluationRepo.save(eval);
    }
        catch(Exception ex)

    {
        throw new LibbeleException("Erreur Fatale");
    }}
    @Override
    public Evaluation getByID(Long id) {
        // TODO Auto-generated method stub
        Evaluation eva = evaluationRepo.findById(id).get();
        Organe organe = pRestClient.getOrganeById(eva.getOrganeID());
        Personnel personnel = pRestClient.getPersoById(eva.getEvaluateurID());
       eva.setOrgane(organe);
        eva.setPersonnel(personnel);
        return eva;
    }
    @Override
    public List<Evaluation> getAll() {
        // TODO Auto-generated method stub
        return evaluationRepo.findAll();
    }
}

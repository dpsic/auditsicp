package com.example.projet.services;

import java.util.List;

import com.example.projet.dao.AspectRepo;
import com.example.projet.dao.RecommandationRepo;
import com.example.projet.entities.Aspect;
import com.example.projet.entities.Recommandation;
import com.example.projet.exceptions.LibbeleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommandationServicesImp implements RecommandationServices {
    @Autowired
    RecommandationRepo recommandationRepo;
    @Autowired
    AspectRepo aspectRepo;

    @Override
    public Recommandation save(Recommandation recommandation) {
        try {
            return recommandationRepo.save(recommandation);
        } catch (Exception ex)

        {
            throw new LibbeleException("Erreur Fatale");
        }
    }

    @Override
    public Recommandation findByReference(String ref) {
        // TODO Auto-generated method stub
        return recommandationRepo.findByReference(ref);
    }

    @Override
    public List<Recommandation> findByAspect(Long idAspect) {
        // TODO Auto-generated method stub
        Aspect ascp = aspectRepo.findById(idAspect).get();
        List<Recommandation> recos = recommandationRepo.findByAspect(ascp);
        return recos;
    }

}

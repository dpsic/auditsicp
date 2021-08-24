package com.example.projet.excel;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.projet.entities.Evaluation;

import com.example.projet.entities.Resultat;
import com.example.projet.services.EvaluationSer;
import com.example.projet.services.ResultatServices;

@Service
public class ExcelService {

    @Autowired
    ExcelHelper excelHelper;
    @Autowired
    ResultatServices recSvc;
    @Autowired
    EvaluationSer evaluationSer;

    public void save(MultipartFile file,Long id) throws ParseException {
       Evaluation eva = evaluationSer.getByID(id);
        try {
            List<Resultat> tutorials = excelHelper.excelToTutorials(file.getInputStream());
            for (Resultat recommandation : tutorials) {
                recommandation.setEvaluation(eva);
                recSvc.save(recommandation);
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    // public List<Book> getAllTutorials() {
    // return repository.findAll();
    // }
}
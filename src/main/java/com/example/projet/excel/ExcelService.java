package com.example.projet.excel;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.projet.entities.Recommandation;
import com.example.projet.services.RecommandationServices;

@Service
public class ExcelService {

    @Autowired
    ExcelHelper excelHelper;
    @Autowired
    RecommandationServices recSvc;

    public void save(MultipartFile file) throws ParseException {
        try {
            List<Recommandation> tutorials = excelHelper.excelToTutorials(file.getInputStream());
            for (Recommandation recommandation : tutorials) {
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
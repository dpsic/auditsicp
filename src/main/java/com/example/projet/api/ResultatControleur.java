package com.example.projet.api;

import com.example.projet.entities.Resultat;
import com.example.projet.services.MapVAlidationErrorService;
import com.example.projet.services.ResultatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/eva/resultats")
public class ResultatControleur {
    @Autowired
    ResultatServices resultatServices;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Resultat resultat, BindingResult result) {
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        Resultat resultat1 = resultatServices.save(resultat);
        return new ResponseEntity<Resultat>(resultat1, HttpStatus.OK);
    }
}

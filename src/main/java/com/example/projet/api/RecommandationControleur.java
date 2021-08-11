package com.example.projet.api;

import com.example.projet.entities.Recommandation;
import com.example.projet.services.MapVAlidationErrorService;
import com.example.projet.services.RecommandationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/eva/recommandations")
public class RecommandationControleur {
    @Autowired
    RecommandationServices recommandationServices;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;
    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Recommandation recommandation, BindingResult result){
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Recommandation recommandation1=recommandationServices.save(recommandation);
        return new ResponseEntity<Recommandation>(recommandation1, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllReco(@PathVariable Long id){
       
        List<Recommandation> recommandation=recommandationServices.findByAspect(id);
        return new ResponseEntity< List<Recommandation> >(recommandation, HttpStatus.OK);
    }
}

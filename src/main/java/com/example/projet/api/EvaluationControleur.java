package com.example.projet.api;

import com.example.projet.entities.Evaluation;
import com.example.projet.services.EvaluationSer;
import com.example.projet.services.MapVAlidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/eva")
public class EvaluationControleur {
    @Autowired
    EvaluationSer evaluationSer;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;
    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Evaluation evaluation, BindingResult result){
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Evaluation eva=evaluationSer.save(evaluation);
        return new ResponseEntity<Evaluation>(eva, HttpStatus.OK);
    }
    @GetMapping("")
    public String hello(){
        return "Hello";
    }
}

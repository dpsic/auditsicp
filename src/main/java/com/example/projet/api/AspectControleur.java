package com.example.projet.api;

import com.example.projet.entities.Aspect;
import com.example.projet.entities.Evaluation;
import com.example.projet.services.AspectServices;
import com.example.projet.services.EvaluationSer;
import com.example.projet.services.MapVAlidationErrorService;
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
@RequestMapping("/api/aspects")
public class AspectControleur {
    @Autowired
    AspectServices aspectServices;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;
    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Aspect aspect, BindingResult result){
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Aspect aspect1=aspectServices.save(aspect);
        return new ResponseEntity<Aspect>(aspect1, HttpStatus.OK);
    }
}

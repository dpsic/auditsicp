package com.example.projet.api;

import com.example.projet.entities.Evaluation;
import com.example.projet.excel.ExcelHelper;
import com.example.projet.excel.ExcelService;
import com.example.projet.excel.ResponseMessage;
import com.example.projet.exceptions.LibbeleException;
import com.example.projet.services.EvaluationSer;
import com.example.projet.services.MapVAlidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/eva")
public class EvaluationControleur {
    @Autowired
    EvaluationSer evaluationSer;
    @Autowired
    MapVAlidationErrorService mapVAlidationErrorService;
    @Autowired
    ExcelService fileService;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody Evaluation evaluation, BindingResult result){
        ResponseEntity<?> errorMap = mapVAlidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Evaluation eva=evaluationSer.save(evaluation);
        return new ResponseEntity<Evaluation>(eva, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Evaluation getEvaById(@PathVariable Long id){
        return evaluationSer.getByID(id) ;
    }
    @GetMapping("")
    public List<Evaluation> geALL(){
        return evaluationSer.getAll();
    }
    
    @PostMapping("/upload")
    public ResponseEntity<?> createSurvey(@RequestPart(required = true) Evaluation e,
            @RequestPart(value = "file", required = false) final MultipartFile file) {
                System.out.println(e.getDateEvaluation());
                    System.out.println(file.getOriginalFilename());
                Evaluation savedEva = evaluationSer.save(e);
            
                String message;
                if (ExcelHelper.hasExcelFormat(file)) {
                    // try {
                    try {
                        fileService.save(file,savedEva.getId());
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
        
                    message = "Uploaded the file successfully: " + file.getOriginalFilename();
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
                 
                }
        
                message = "Please upload an excel file!";
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));


        
        
        

    }

}

package com.example.projet.excel;

import org.springframework.http.HttpStatus;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

// @CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/eva/excel")
public class ExcelController {

    @Autowired
    ExcelService fileService;

    @PostMapping("")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws ParseException {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            // try {
            fileService.save(file,2L);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            // } catch (Exception e) {
            /// message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            // return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
            // ResponseMessage(message));
            // }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    // @GetMapping("/tutorials")
    // public ResponseEntity<List<Book>> getAllTutorials() {
    // try {
    // List<Book> tutorials = fileService.getAllTutorials();

    // if (tutorials.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }

    // return new ResponseEntity<>(tutorials, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}

package com.example.projet.entities;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@JsonFormat(pattern = "dd-mm-yyyy")
private Date dateEvaluation;
    @JsonFormat(pattern = "dd-mm-yyyy")
private Date dateValidation;
    @NotNull(message = "Champ Obligatoire")
private String organ;
    @NotNull(message = "Champ Obligatoire")
private String auteur;
    @NotNull(message = "Champ Obligatoire")
private String Validation;

    public Evaluation() {
    }

    public Evaluation(Date dateEvalution, Date dateValidation, String organ, String auteur, String validation) {
        this.dateEvaluation = dateEvaluation;
        this.dateValidation = dateValidation;
        this.organ = organ;
        this.auteur = auteur;
        Validation = validation;
    }

    public Date getDateEvalution() {
        return dateEvaluation;
    }

    public void setDateEvalution(Date dateEvalution) {
        this.dateEvaluation = dateEvalution;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getValidation() {
        return Validation;
    }

    public void setValidation(String validation) {
        Validation = validation;
    }
}

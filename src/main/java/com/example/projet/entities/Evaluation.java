package com.example.projet.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String validation;
    @OneToMany(mappedBy = "evaluation")
    private List<Resultat> resultat=new ArrayList<>();

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Date return the dateEvaluation
     */
    public Date getDateEvaluation() {
        return dateEvaluation;
    }

    /**
     * @param dateEvaluation the dateEvaluation to set
     */
    public void setDateEvaluation(Date dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    /**
     * @return Date return the dateValidation
     */
    public Date getDateValidation() {
        return dateValidation;
    }

    /**
     * @param dateValidation the dateValidation to set
     */
    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    /**
     * @return String return the organ
     */
    public String getOrgan() {
        return organ;
    }

    /**
     * @param organ the organ to set
     */
    public void setOrgan(String organ) {
        this.organ = organ;
    }

    /**
     * @return String return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * @return List<Resultat> return the resultat
     */
    public List<Resultat> getResultat() {
        return resultat;
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(List<Resultat> resultat) {
        this.resultat = resultat;
    }

    public Evaluation() {
    }

    /**
     * @return String return the validation
     */
    public String getValidation() {
        return validation;
    }

    /**
     * @param validation the validation to set
     */
    public void setValidation(String validation) {
        this.validation = validation;
    }

}

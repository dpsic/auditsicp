package com.example.projet.entities;

import com.example.projet.modals.Organe;
import com.example.projet.modals.Personnel;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateEvaluation;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateValidation;
    private String validateur;

    @OneToMany(mappedBy = "evaluation")
    private List<Resultat> resultat = new ArrayList<>();
    private Long evaluateurID;
    private Long organeID;
    @Transient
    private Organe organe;
    @Transient
    private Personnel personnel;


    public String getValidateur() {
        return validateur;
    }

    public void setValidateur(String validateur) {
        this.validateur = validateur;
    }

    public Long getEvaluateurID() {
        return evaluateurID;
    }

    public void setEvaluateurID(Long evaluateurID) {
        this.evaluateurID = evaluateurID;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Organe getOrgane() {
        return organe;
    }

    public void setOrgane(Organe organe) {
        this.organe = organe;
    }

 
    public Long getOrganeID() {
        return organeID;
    }

    public void setOrganeID(Long organeID) {
        this.organeID = organeID;
    }

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



}

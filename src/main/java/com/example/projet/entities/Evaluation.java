package com.example.projet.entities;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "ID_EV_RE")
    private Resultat resultat;
    @ManyToOne
    @JoinColumn(name = "ID_RE_REC")
    private Recommandation recommandation;
    @ManyToOne
    @JoinColumn(name = "ID_AS_REC")
    private Recommandation recommandation1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Date dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public Recommandation getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(Recommandation recommandation) {
        this.recommandation = recommandation;
    }

    public Recommandation getRecommandation1() {
        return recommandation1;
    }

    public void setRecommandation1(Recommandation recommandation1) {
        this.recommandation1 = recommandation1;
    }

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

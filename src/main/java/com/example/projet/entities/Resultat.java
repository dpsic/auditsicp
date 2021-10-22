package com.example.projet.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean cotation;
    private String methode;
    @ManyToOne
    @JoinColumn(name = "ID_EVA")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Evaluation evaluation;
    @ManyToOne
    @JoinColumn(name = "ID_RECO")
    private Recommandation recommandation;
    private Boolean active=true;
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCotation() {
        return cotation;
    }

    public void setCotation(boolean cotation) {
        this.cotation = cotation;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    /**
     * @return Recommandation return the recommandation
     */
    public Recommandation getRecommandation() {
        return recommandation;
    }

    /**
     * @param recommandation the recommandation to set
     */
    public void setRecommandation(Recommandation recommandation) {
        this.recommandation = recommandation;
    }

}

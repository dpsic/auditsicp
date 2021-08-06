package com.example.projet.entities;

import javax.persistence.*;

@Entity
public class Recommandation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String label;
    @ManyToOne
    @JoinColumn(name = "ID_RES")
    private Resultat resultat;
    @ManyToOne
    @JoinColumn(name = "ID_ASP")
    private Aspect aspect;

    public Recommandation() {
    }

    public Recommandation(String reference, String label) {
        this.reference = reference;
        this.label = label;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
     * @return Resultat return the resultat
     */
    public Resultat getResultat() {
        return resultat;
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    /**
     * @return Aspect return the aspect
     */
    public Aspect getAspect() {
        return aspect;
    }

    /**
     * @param aspect the aspect to set
     */
    public void setAspect(Aspect aspect) {
        this.aspect = aspect;
    }

}

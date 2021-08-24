package com.example.projet.modals;

import java.util.ArrayList;
import java.util.List;





public class Personnel {
 
    private Long id;

    private String nom;
  
    private String prenom;

    private Grade grade;


   private Organe organe;

    private String fonction;

    private List<String> fonctionSiActuelle = new ArrayList<>();
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
    public List<String> getFonctionSiActuelle() {
        return fonctionSiActuelle;
    }
    public void setFonctionSiActuelle(List<String> fonctionSiActuelle) {
        this.fonctionSiActuelle = fonctionSiActuelle;
    }
    private String mail;
 
    private String tel;


    
    public Organe getOrgane() {
        return organe;
    }
    public void setOrgane(Organe organe) {
        this.organe = organe;
    }
    public Personnel() {
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Grade getGrade() {
        return grade;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
  
    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    
}

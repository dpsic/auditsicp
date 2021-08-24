package com.example.projet.modals;

import java.util.Date;




public class OccuperFonction {
 
    private Long id;

    private Personnel personnel;
    private FonctionSi fonctionSi;
    private Date dateDebut;
    private Date dateFin;
    private boolean active=true;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public OccuperFonction() {
    }
    public Personnel getPersonnel() {
        return personnel;
    }
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    public FonctionSi getFonctionSi() {
        return fonctionSi;
    }
    public void setFonctionSi(FonctionSi fonctionSi) {
        this.fonctionSi = fonctionSi;
    }
    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    
}

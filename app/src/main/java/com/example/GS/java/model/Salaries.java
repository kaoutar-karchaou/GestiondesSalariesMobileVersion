package com.example.GS.java.model;

import java.util.Date;

public class Salaries {
    private String id ;
    private String nom  ;
    private String prenom  ;
    private String cin ;
    private String adresse ;
    private String telephone;
    private String email;
    private Date dateNaissance;
    private String departement ;
    private String emploiOccupe;
    private int Anciennete ;
    private double salaireBase ;

    public Salaries() {
    }

    public Salaries(String nom, String prenom, String cin, String adresse, String telephone, String email, Date dateNaissance, String departement, String emploiOccupe, int anciennete, double salaireBase) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.departement = departement;
        this.emploiOccupe = emploiOccupe;
        Anciennete = anciennete;
        this.salaireBase = salaireBase;
    }

    public String getId() {
        return id;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getEmploiOccupe() {
        return emploiOccupe;
    }

    public void setEmploiOccupe(String emploiOccupe) {
        this.emploiOccupe = emploiOccupe;
    }

    public int getAnciennete() {
        return Anciennete;
    }

    public void setAnciennete(int anciennete) {
        Anciennete = anciennete;
    }

    public double getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(double salaireBase) {
        this.salaireBase = salaireBase;
    }

    @Override
    public String toString() {
        return "Salaries{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", departement='" + departement + '\'' +
                ", emploiOccupe='" + emploiOccupe + '\'' +
                ", Anciennete=" + Anciennete +
                ", salaireBase=" + salaireBase +
                '}';
    }
}

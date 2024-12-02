package com.example.myhotel;

public class Hotel {
    private String name;
    private String description;
    private String telephone;
    private double rate;

    // Constructeur
    public Hotel(String name, String description, String telephone, double rate) {
        this.name = name;
        this.description = description;
        this.telephone = telephone;
        this.rate = rate;
    }

    // Getter et setter pour le nom de l'hôtel
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter et setter pour la description de l'hôtel
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter et setter pour le numéro de téléphone de l'hôtel
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Getter et setter pour le taux de l'hôtel
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
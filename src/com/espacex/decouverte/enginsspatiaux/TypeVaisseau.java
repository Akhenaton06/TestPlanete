package com.espacex.decouverte.enginsspatiaux;

public enum TypeVaisseau {

    CHASSEUR("Chasseur"), FREGATE("Frégate"), CROISEUR("Croiseur"), CARGO("Cargo"), VAISSEAUMONDE("Vaisseau-Monde");
    private String nom;

     TypeVaisseau(String nom) {
        this.nom = nom;
    }


}

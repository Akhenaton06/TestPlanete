package com.espacex.decouverte.enginsspatiaux;



public abstract class Vaisseau {
    protected final TypeVaisseau type;
    public int nbPassagers;
    public int resistanceDuBouclier;
    public int blindage;
    protected int tonnageMax;
    protected int tonnageActuel;


    public void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+this.type.name()+".");
    }

    public void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+this.type.name()+".");
    }

    public abstract void emporterCargaison(int tonnage) throws DepassementTonnageException;

    public  Vaisseau(TypeVaisseau type){
        this.type=type;
    }
}

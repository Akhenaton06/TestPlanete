package com.espacex.decouverte.enginsspatiaux;

public class DepassementTonnageException extends Exception{
    private int tonnageEnExces;

    public DepassementTonnageException(int tonnageEnExces) {
        super("Le vaisseau a rejété la cargaison  car elle présente un excès de: "+tonnageEnExces);
        this.tonnageEnExces = tonnageEnExces;

    }

    public int getTonnageEnExces() {
        return tonnageEnExces;
    }
}

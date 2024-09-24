package com.espacex.decouverte.objetsastro;

import com.espacex.decouverte.enginsspatiaux.Vaisseau;
import com.espacex.decouverte.enginsspatiaux.VaisseauDeGuerre;

public class PlaneteTellurique extends Planete implements Habitable {

    private Vaisseau[][] vaisseauxAccostes ;
    private int totalVisiteurs;

    public PlaneteTellurique(String nom, int tailleDeLaBaie) {
        super(nom);
        vaisseauxAccostes= new Vaisseau[2][tailleDeLaBaie];
    }
    @Override
    public void accueillirVaisseau(Vaisseau... nouveauVaisseau){

            for(int i=0; i< nouveauVaisseau.length; i++){
                int indexZone=0;
                if (nouveauVaisseau[i] instanceof VaisseauDeGuerre){
                    ((VaisseauDeGuerre) nouveauVaisseau[i]).desactiverArmes();
                    indexZone=1;
                }

                for (int j = 0; j < vaisseauxAccostes[indexZone].length; j++) {
                    if( this.vaisseauxAccostes [indexZone][j]== null){
                        vaisseauxAccostes[indexZone][j]= nouveauVaisseau[i];
                        break;
                    }
                }
                totalVisiteurs+=nouveauVaisseau[i].nbPassagers;
            }


    }

    public boolean restePlaceDisponible(Vaisseau vaisseau){

        int indexZone=0;
        if (vaisseau instanceof VaisseauDeGuerre){
            indexZone=1;
        }
        for(int i=0; i< this.vaisseauxAccostes[indexZone].length; i++){
            if( this.vaisseauxAccostes[indexZone][i]== null){
                return true;
            }

        }
        return false;
    }
}






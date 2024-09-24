package com.espacex.decouverte;

import com.espacex.decouverte.enginsspatiaux.*;
import com.espacex.decouverte.objetsastro.*;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static com.espacex.decouverte.enginsspatiaux.TypeVaisseau.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        //Initialisation de la galaxie
        Galaxie systemSolaire= new Galaxie();
        systemSolaire.nom="Système solaire";

        //Création de planètes
        Planete mercure = new PlaneteTellurique("Mercure",2);
        mercure.diametre = 4880;
        mercure.distanceEtoile=57.9f;

        Planete venus = new PlaneteTellurique("Venus",6);
        venus.diametre = 12100;
        venus.distanceEtoile=108.2f;

        Planete terre = new PlaneteTellurique("Terre",5);
        terre.diametre = 12756;
        terre.distanceEtoile=149.6f;

        Planete mars = new PlaneteTellurique("Mars",2);
        mars.diametre = 6792;
        mars.distanceEtoile=227.9f;

        Planete jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.distanceEtoile=778.3f;

        Planete saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile=1427.0f;

        Planete uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile=2877.38f;

        Planete neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile=4497.07f;


        //Ajout des planetes dans le systeme solaire
        systemSolaire.planetes.add(saturne);
        systemSolaire.planetes.add(neptune);
        systemSolaire.planetes.add(uranus);
        systemSolaire.planetes.add(jupiter);
        systemSolaire.planetes.add(mars);
        systemSolaire.planetes.add(terre);
        systemSolaire.planetes.add(venus);
        systemSolaire.planetes.add(mercure);




        //Création de vaisseaux
        Vaisseau chasseur = new VaisseauDeGuerre(CHASSEUR);
        chasseur.nbPassagers = 3;
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau croiseur = new VaisseauDeGuerre(CROISEUR);
        croiseur.nbPassagers = 35;
        croiseur.blindage = 851;
        croiseur.resistanceDuBouclier = 25;

        Vaisseau fregate = new VaisseauDeGuerre(FREGATE);
        fregate.nbPassagers = 100;
        fregate.blindage = 542;
        fregate.resistanceDuBouclier = 50;

        Vaisseau cargo = new VaisseauCivil(CARGO);
        cargo.nbPassagers = 10000;
        cargo.blindage = 1520;
        cargo.resistanceDuBouclier = 20;

        Vaisseau vaisseauMonde = new VaisseauCivil(VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 10000;
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;

        Atmosphere atmosphereMars= new Atmosphere();
        atmosphereMars.constituants.put("CO2", 95f);
        atmosphereMars.constituants.put("N2", 3f);
        atmosphereMars.constituants.put("AR", 1.5f);
        atmosphereMars.constituants.put("NO", 0.013f);

        //Affichage de la plenète Mars et ses constituants
        mars.atmosphere=atmosphereMars;
        System.out.println("L'atmosphère de Mars est composé:");
        for (Map.Entry<String, Float>  constituants: mars.atmosphere.constituants.entrySet()) {

            System.out.println(constituants.getValue()+ "% de "+ constituants.getKey());
        }

        //Affiche l'ordre des planètes par rapport à la distance du soleil
        for (Planete planete: systemSolaire.planetes) {
            System.out.println(planete.nom+" "+planete.distanceEtoile+"Km");
        }





        //boolean validation= false;
        boolean recommencerLeCode=true;

       // planeteSelectionnee=terre;
        // planeteSelectionnee.accueillirVaisseau(chasseur,cargo);


        while (recommencerLeCode){
            int tonnageSouhaite;


            System.out.println("Quel vaisseau souhaitez vous manipuler​ : "+ CHASSEUR+", "+ FREGATE+", "+ CROISEUR+", "+ CARGO+" ou "+ VAISSEAUMONDE.name()+" ?");
            System.out.print("Vaisseau: ");
            String typeVaisseauString = sc.nextLine();
           // System.out.println("Sur quelle planète tellurique en partant du systeme solaire voulez-vous vous poser : 1, 2 ,3 ou 4 ?");
            //int numeroPlanete = sc.nextInt();
            System.out.println("Sur quelle planète tellurique en partant du systeme solaire voulez-vous vous poser : Mercure, Venus ,Terre ou Mars ?");
            String nomPlanete = sc.nextLine();
            //sc.nextLine();

            while (true){
                System.out.println("Quel tonnage souhaitez-vous emporter ?");
                try {
                    tonnageSouhaite = sc.nextInt();
                    break;

                }catch (InputMismatchException ime){
                    System.out.println("Le tonnage n'est pas numérique:"+ime.getMessage());

                } finally {
                    sc.nextLine();
                }

            }





            TypeVaisseau typeVaisseau= TypeVaisseau.valueOf(typeVaisseauString);
            Vaisseau vaisseauSelectionne = null;
            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseauSelectionne = chasseur;
                    break;
                case FREGATE:
                    vaisseauSelectionne = fregate;
                    break;
                case CROISEUR:
                    vaisseauSelectionne = croiseur;
                    break;
                case CARGO:
                    vaisseauSelectionne = cargo;
                    break;
                case VAISSEAUMONDE:
                    vaisseauSelectionne = vaisseauMonde;
                    break;
            }

            //pour les Hashets
            Planete planeteSelectionnee= null;
            for (Planete p: systemSolaire.planetes) {

                if(p.nom.equals(nomPlanete)){
                    planeteSelectionnee=p;
                    break;
                }
            }
            //Pour les lists
           // Planete p= systemSolaire.planetes.get(numeroPlanete-1);
            System.out.println("Vous avez choisi "+planeteSelectionnee.nom);
            if(planeteSelectionnee instanceof PlaneteGazeuse){

                System.out.println("La planète selectionnée n'est pas  une planete Tellurique, recommencez.");
                continue;
            }

            // Pour les lists
           // PlaneteTellurique planeteSelectionnee=(PlaneteTellurique) p;
            //pour les Hashets
            PlaneteTellurique planete=(PlaneteTellurique) planeteSelectionnee;
            if(planete.restePlaceDisponible(vaisseauSelectionne)){
                planete.accueillirVaisseau(vaisseauSelectionne);
                try {
                     vaisseauSelectionne.emporterCargaison(tonnageSouhaite);
                } catch (DepassementTonnageException e) {
                    System.out.println(e.getMessage() + " tonnes. ");
                    System.out.println("Voulez-vous emporter un tonnage partiel en hauteur de: "+(tonnageSouhaite-e.getTonnageEnExces())+" tonnes."+ " (oui/non) ?");
                    String accepte= sc.nextLine();
                    if(accepte.equals("oui")){
                        tonnageSouhaite-=e.getTonnageEnExces();
                        try {
                            vaisseauSelectionne.emporterCargaison(tonnageSouhaite);
                        } catch (DepassementTonnageException ex) {
                            System.out.println("Erreur inattendue.");
                        }
                    }
                    else
                        System.out.println("Opération annulée");
                }
            }
            else{
                System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie. ");
            }

            System.out.println("voulez-vous recommencer oui/non");
            recommencerLeCode= sc.nextLine().equalsIgnoreCase("oui");
        }



    }
}
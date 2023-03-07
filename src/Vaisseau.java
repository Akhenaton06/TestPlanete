
public abstract class Vaisseau {
    String type;
    int nbPassagers;
    int resistanceDuBouclier;
    int blindage;
    int tonnageActuel;
    int tonnageMax;



    void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+type+".");
    }

    void desactiverBouclier(){
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+type+".");
    }

    //abstract int emporterCargaison(int tonnage);


}

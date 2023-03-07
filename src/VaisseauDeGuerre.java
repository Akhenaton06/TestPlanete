public class VaisseauDeGuerre extends Vaisseau {

    VaisseauDeGuerre(){
        super();
    }

    boolean armesDesactivees;

    void attaque(Vaisseau vaisseauCible, String arme, int duree) {
        if (armesDesactivees) {
            System.out.println("Attaque impossible, l'armement est désactivé");
        } else {
            System.out.println("Un vaisseau de type " + type + " attaque un vaisseau de type " + vaisseauCible.type + " en utilisant l'arme " + arme + " pendant " + duree + " minutes.");
            vaisseauCible.resistanceDuBouclier = 0;
            vaisseauCible.blindage = vaisseauCible.blindage / 2;
        }
    }

    void desactiverArmes() {
        System.out.println("Désactivation des armes d'un vaisseau de type " + type);
        armesDesactivees = true;
    }

    void activerBouclier(){
        System.out.println("Activation du bouclier d'un vaisseau de type "+type+".");
        desactiverArmes();
    }

}

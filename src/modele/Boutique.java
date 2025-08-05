package modele;

import java.util.ArrayList;

public class Boutique {

    // inventaire des fleurs qu'on a récolté
    int nbRose = 0;
    int nbTulipe = 0;
    int nbTournesol = 0;
    int nbMuguets = 0;
    int nbFleurBleue = 0;

    // on stocke les fleurs recoltés dans l'inventaires
    ArrayList<Fleur> inventaire;

    // fleurs qu'on va vendre

    ArrayList<Fleur> bouquet;


    Carte c;
    public Boutique(Carte c){

        this.c = c;
        bouquet = new ArrayList<Fleur>();
        inventaire = new ArrayList<Fleur>();
    }




    // on ajoute une fleur au bouquet
    // si on peut l'ajouter on revoie true sinon on renvoie false
    public boolean ajouterTulipeAuBouquet(){
        for (int i=0;i<inventaire.size();i++){
            if (inventaire.get(i) instanceof Tulipe){
                bouquet.add(inventaire.get(i));
                inventaire.remove(i);
                nbTulipe--;
                return true;
            }
        }
        return false;
    }

    public boolean ajouterRoseAuBouquet(){
        for (int i=0;i<inventaire.size();i++){
            if (inventaire.get(i) instanceof Rose){
                bouquet.add(inventaire.get(i));
                inventaire.remove(i);
                nbRose--;
                return true;
            }
        }
        return false;
    }

    public boolean ajouterTournesolAuBouquet(){
        for (int i=0;i<inventaire.size();i++){
            if (inventaire.get(i) instanceof Tournesol) {
                bouquet.add(inventaire.get(i));
                inventaire.remove(i);
                nbTournesol--;
                return true;
            }
        }
        return false;
    }

    public boolean ajouterMuguetAuBouquet(){
        for (int i=0;i<inventaire.size();i++){
            if (inventaire.get(i) instanceof Muguet){
                bouquet.add(inventaire.get(i));
                inventaire.remove(i);
                nbMuguets--;
                return true;
            }
        }
        return false;
    }

    public boolean ajouterFleurBleueAuBouquet(){
        for (int i=0;i<inventaire.size();i++){
            if (inventaire.get(i) instanceof FleurBleue){
                bouquet.add(inventaire.get(i));
                inventaire.remove(i);
                nbFleurBleue--;
                return true;
            }
        }
        return false;
    }




    // à chaque fois qu'on récolte une fleur on l'ajoute à l'inventaire
    public void ajouterFleurInventaire(Fleur f){
        if (f instanceof Rose) {
                nbRose++;
                inventaire.add(f);
        } else if (f instanceof Tulipe) {
                nbTulipe++;
                inventaire.add(f);
        } else if (f instanceof Tournesol) {
                nbTournesol++;
                inventaire.add(f);
        } else if (f instanceof Muguet) {
                nbMuguets++;
                inventaire.add(f);
        } else if (f instanceof FleurBleue) {
                nbFleurBleue++;
                inventaire.add(f);
        }
    }

    public int getNbrRose() {
        return nbRose;
    }
    public int getNbrTulipe() {
        return nbTulipe;
    }
    public int getNbrTournesol() {return nbTournesol;}
    public int getNbrMuguet() {
        return nbMuguets;
    }
    public int getNbrFleurBleue() {
        return nbFleurBleue;
    }




    public ArrayList<Fleur> getBouquet() {
        return bouquet;
    }

    // quand on vend le bouquet de fleur on ajoute le score et on vide le bouquet
    public boolean vendre(){
        int score = 0;
        if (bouquet.size() != 3){
            return false;
        } else {
            for (Fleur f : bouquet) {
                score += f.getPrix();
            }
            c.ajoutScore(score);
            bouquet.clear();
            return true;
        }
    }

    // on enlève une fleur du bouquet selon le numero de la fleur et on la rajoute à l'inventaire
    public void enleverFleurBouquet(int nb){
        if (nb < bouquet.size()){
            Fleur f = bouquet.get(nb);
            ajouterFleurInventaire(f);
            bouquet.remove(nb);
        }
    }

    public boolean engagerJardinier(){
        return (c.getScore() >= c.getPrixJardinier());
    }





}

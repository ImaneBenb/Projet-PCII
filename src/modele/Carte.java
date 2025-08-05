package modele;

import java.util.ArrayList;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Carte {

    private ArrayList<Jardinier> jardiniers;

    private ArrayList<Fleur> fleurs;

    private int score;

    private final int scoreFinal = 250;

    private final int prixJardnier = 100;

    Boutique boutique;


    public Carte() {
        score =50;
        boutique = new Boutique(this);
        jardiniers = new ArrayList<Jardinier>();
        fleurs = new ArrayList<Fleur>();
        Jardinier j = new Jardinier(150, 100 , 10, "jardinier n°0");

        jardiniers.add(j);
    }

    public ArrayList<Jardinier> getListJardinier(){return jardiniers;}

    public boolean aucunJardnierSelectionner(){
        for(Jardinier j:jardiniers){
            if (j.isSelected())
                return false;
        }
        return true;
    }

    public void deselectionnerAutresJardnier(Jardinier j){
        for (Jardinier jardinier:jardiniers){
            if (jardinier!=j){
                jardinier.setSelected(false);
                jardinier.setDesherber(false);
                jardinier.setPlanter(false);
                jardinier.setRecolter(false);
                jardinier.setMoving(false);

            }
        }
    }

    // permet de deselectionner toutes les fleurs sauf celle passée en parametre
    public void deselectionnerAutreFleur(Fleur f){
        for (Fleur fleur:fleurs){
            if (fleur!=f){
                fleur.setSelected(false);
            }
        }
    }

    public ArrayList<Fleur> getListFleurs() {
        return fleurs;
    }



    public boolean aucuneFleurSelectionner() {
        for (Fleur f:fleurs){
            if(f.isSelected()){
                return false;
            }
        }
        return true;
    }

    public int getScore() {
        return score;
    }
    public void ajoutScore(int s){
        score += s;
    }

    // decremente le score et on verifie si c'est possible
    public boolean decrementeScore(int s){
        if (score <s)
            return false;
        else {
            score -= s;
            return true;
        }
    }

    public void ajouterFleurInventaire(Fleur f){
       boutique.ajouterFleurInventaire(f);
    }

    // verifie si le score est superieur ou egal a 500
    public boolean partieGagnee(){
        return score >= scoreFinal;
    }

    public Boutique getBoutique() {
        return boutique;
    }

    public int getScoreFinal() {
        return scoreFinal;
    }



    public boolean engagerJardinier() {
        if ( score >= prixJardnier){
            score -= prixJardnier;
            jardiniers.add(new Jardinier(150, 100 , 10, "jardinier n°"+jardiniers.size()));
            return true;
        }else{
            return false;
        }

    }

    public boolean fleurAProximiteJardinier(Jardinier jardinier){

        for (int i = 0; i < fleurs.size(); i++) {
            Fleur f = fleurs.get(i);
            if (sqrt(pow( (f.getX() - jardinier.getX()), 2) + pow((f.getY() - jardinier.getY()), 2) ) < Jardinier.RAYON) {
                return true;
            }
        }
        return false;
    }

    public int getPrixJardinier() {
        return prixJardnier;
    }
}

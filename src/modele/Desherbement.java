package modele;

import vue.PanneauControle;
import vue.VueCarte;

// thread pour permettre le desherbement et de bloquer le jardinier
public class Desherbement  extends Thread{

    private int time = 500;
    Jardinier jardinier;
    Carte carte;
    Fleur fleur;
    VueCarte vueCarte;

    private int DELAI_DESHERBEMENT; // temps qu'il faut pour desherber : le jardinier reste bloque

    private int tempsEnCoursDesherbement; // le temps qu'on a passé pour desherber
    private PanneauControle panneauControle;

    public Desherbement(Carte c , VueCarte vc,Jardinier j, PanneauControle pc,Fleur f) {
        panneauControle =pc;
        jardinier= j;
        carte=c;
        vueCarte=vc;
        fleur=f;
        jardinier.setBloque(true);
        DELAI_DESHERBEMENT =j.getDelaiDesherbement();
        tempsEnCoursDesherbement=0;
    }

    //threads
    @Override
    public void run() {
        jardinier.setBloque(true);
        fleur.setDesherbementEnCours(true);
        vueCarte.demarrerAnimationDesherber();
        while(tempsEnCoursDesherbement <  DELAI_DESHERBEMENT) {
            try {
                tempsEnCoursDesherbement++;
                Thread.sleep(time);
                if (!carte.getListFleurs().contains(fleur)) {
                    vueCarte.arreterAnimationDesherber();
                    break;
                }

            }
            catch (Exception e) { e.printStackTrace(); }
        }
        carte.getListFleurs().remove(fleur);
        panneauControle.updatePanneau();
        jardinier.setBloque(false);
        jardinier.setDesherber(false);
        fleur.setDesherbementEnCours(false);
        vueCarte.arreterAnimationDesherber();
    }
}


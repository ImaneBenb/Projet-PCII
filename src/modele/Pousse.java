package modele;

import vue.PanneauControle;
import vue.VueCarte;

public class Pousse extends Thread{

    private int time = 500;
    Fleur fleur;


    private PanneauControle panneauControle;

    VueCarte vueCarte;

    public Pousse( VueCarte vc, Fleur f, PanneauControle pc) {
        panneauControle =pc;
        fleur = f;
        vueCarte = vc;
    }

    //threads
    @Override
    public void run() {
        vueCarte.demarrerAnimationPlanter();
        while(!fleur.estFanee()) {
            try {
                    fleur.pousser();
                    if (fleur.isSelected()){
                       panneauControle.updatePanneau();
                    }
                    if (fleur.estRecoltable()){
                        // on arrete l'animation de la pousse quand la fleur est récoltable
                        vueCarte.arreterAnimationPlanter();
                    }


                Thread.sleep(time);
            }
            catch (Exception e) { e.printStackTrace(); }
        }

    }
}

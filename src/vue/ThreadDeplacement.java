package vue;

import modele.Jardinier;

public class ThreadDeplacement extends Thread{


    private int DELAI_DEPLACEMENT = 20;

    private Jardinier j;

    private PanneauControle panneauControle;

    public ThreadDeplacement( Jardinier jardinier , PanneauControle p){
        j  = jardinier;
        panneauControle = p;
    }
    @Override
    public void run() {
        while (j.isSelected() && ( j.isMoving() && j.getX()!=j.getDestinationX() || j.getY()!=j.getDestinationY())) {
            try {
                j.deplacerUnite();
        // Mise en pause du thread pendant un court moment pour simuler un déplacement lent
                Thread.sleep(DELAI_DEPLACEMENT);
            }
             catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        panneauControle.updatePanneau();

    }
}

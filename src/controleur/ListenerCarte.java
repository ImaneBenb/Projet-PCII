package controleur;


import modele.*;
import vue.Fenetre;
import vue.PanneauControle;
import vue.ThreadDeplacement;
import vue.VueCarte;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ListenerCarte implements MouseListener {

    Carte carte;

    PanneauControle panneauControle;

    VueCarte vueCarte;

    private int RAYON = Jardinier.RAYON;

    Fenetre fenetre;

    public ListenerCarte(Carte c, PanneauControle pc , Fenetre f, VueCarte vc) {
        carte = c;
        panneauControle = pc;
        vueCarte = vc;
        fenetre = f;
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        fenetre.effacerMessageErreur();
// pour les jardiniers
        for (Jardinier jardinier : carte.getListJardinier()) {
            if (!jardinier.isBloque()) {



                double distance = sqrt(pow(x - jardinier.getX(), 2) + pow(y - jardinier.getY(), 2));

                //si on clique ou on a un jardinier
                if (!jardinier.isSelected() && RAYON >= distance) {
                    carte.deselectionnerAutresJardnier(jardinier);
                    carte.deselectionnerAutreFleur(null); // pour deselectionner toutes les fleurs
                    jardinier.setSelected(true);
                    panneauControle.updatePanneau();
                    vueCarte.demarrerAnimationDeplacement();
                }
                // si le jardinier est selectionnee
                else if (jardinier.isSelected()) {
                    // si on est en mouvement
                    if (jardinier.isMoving()) {
                        jardinier.setPlanter(false);
                        jardinier.setRecolter(false);
                        jardinier.setDesherber(false);
                        jardinier.setDestination(x, y);
                        (new ThreadDeplacement(jardinier, panneauControle)).start();
                        fenetre.updateScore(true);
                    }
                    // si on veut recolter une fleur
                    else if (jardinier.recolter()) {
                        jardinier.setRecolter(false);
                        jardinier.setPlanter(false);
                        jardinier.setMoving(false);
                        jardinier.setDesherber(false);
                        panneauControle.updatePanneau();
                        for (int i = 0; i < carte.getListFleurs().size(); i++) {
                            Fleur f = carte.getListFleurs().get(i);
                            if (f.estRecoltable() && RAYON >= distance && f.getX() - f.getTaille() / 2 <= x && x <= (f.getX() + f.getTaille() / 2) && f.getY() - f.getTaille() / 2 <= y && y <= (f.getTaille() / 2 + f.getY())){
                                    carte.getListFleurs().remove(f);
                                    carte.ajouterFleurInventaire(f);
                                    panneauControle.updateInventaire();
                            }
                        }
                    }
                    // si le jardinier doit planter on ne peut planter qu'une fleur a cote du jardinier
                    else if (jardinier.getPlanter()) {
                        jardinier.setRecolter(false);
                        jardinier.setMoving(false);
                        jardinier.setPlanter(false);
                        jardinier.setDesherber(false);
                        panneauControle.updatePanneau();
                        // on ne peut planter qu'une fleur a cote du jardinier
                        if (RAYON >= distance && !carte.fleurAProximiteJardinier(jardinier)) {
                            vueCarte.addPopUpMenu(x, y);
                        }
                    }
                    else if (jardinier.desherbementEnCours()) {
                        jardinier.setRecolter(false);
                        jardinier.setMoving(false);
                        jardinier.setPlanter(false);
                        jardinier.setDesherber(false);
                        panneauControle.updatePanneau();

                        for (int i = 0; i < carte.getListFleurs().size(); i++) {
                            Fleur f = carte.getListFleurs().get(i);
                            if (RAYON >= distance && f.estFanee() && f.getX() - f.getTaille() / 2 <= x && x <= (f.getX() + f.getTaille() / 2) && f.getY() - f.getTaille() / 2 <= y && y <= (f.getTaille() / 2 + f.getY())) {
                                (new Desherbement(carte,vueCarte, jardinier, panneauControle,f)).start();
                                panneauControle.updatePanneau();
                            }
                        }

                    }
                }
            }
        }
            //gestion fleurs
            for (int i = 0; i < carte.getListFleurs().size(); i++) {
                Fleur f = carte.getListFleurs().get(i);

                // si la fleur est selectionnee
                if (f.getX()- f.getTaille()/2 <= x  && x <= (f.getX() + f.getTaille()/2) && f.getY()  - f.getTaille()/2 <= y && y <= (f.getTaille()/2 + f.getY())) {
                    f.setSelected(true);
                    carte.deselectionnerAutresJardnier(null);
                    carte.deselectionnerAutreFleur(f);
                    panneauControle.updatePanneau();
                }
                else {
                    f.setSelected(false);


                }
            }
            // aucun des jardiniers est selectionnee et aucune des fleurs n'est selectionnees
            if (carte.aucunJardnierSelectionner() && carte.aucuneFleurSelectionner()) {
                panneauControle.updatePanneau();
            }





    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

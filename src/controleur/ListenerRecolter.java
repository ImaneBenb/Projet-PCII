package controleur;

import modele.Carte;
import modele.Jardinier;
import vue.PanneauJardinier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRecolter implements ActionListener {
    Jardinier jardinier;

    Carte carte;
    PanneauJardinier panneauJardinier;
    public ListenerRecolter(Jardinier j , Carte c , PanneauJardinier p){
        jardinier=j;
        carte =c;
        panneauJardinier = p;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //verifier qu'on peut bien recolter
    jardinier.setRecolter(true);
    jardinier.setPlanter(false);
    jardinier.setMoving(false);
    jardinier.setDesherber(false);
    panneauJardinier.update(jardinier);


        }

    public void setJardnier(Jardinier j) {
        jardinier  = j;
    }




}

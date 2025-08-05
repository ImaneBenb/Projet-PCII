package controleur;

import modele.Jardinier;
import vue.PanneauJardinier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDesherber implements ActionListener {
    Jardinier jardinier;
    PanneauJardinier panneauJardinier;

    public ListenerDesherber(Jardinier j , PanneauJardinier p ){
        jardinier=j;
        panneauJardinier = p;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        jardinier.setDesherber(true);
        jardinier.setPlanter(false);
        jardinier.setRecolter(false);
        jardinier.setMoving(false);
        panneauJardinier.update(jardinier);
    }

    public void setJardinier(Jardinier j) {
        jardinier = j;
    }
}

package controleur;

import modele.Jardinier;
import vue.PanneauJardinier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerPlanter implements ActionListener {



    Jardinier jardinier;

    PanneauJardinier panneauJardinier;


    public ListenerPlanter( Jardinier j , PanneauJardinier p){
        jardinier = j;
        panneauJardinier = p;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jardinier.setPlanter(true);
        jardinier.setRecolter(false);
        jardinier.setMoving(false);
        jardinier.setDesherber(false);
        panneauJardinier.update(jardinier);
    }

    public void setJardinier(Jardinier j) {
        this.jardinier =j;
    }
}

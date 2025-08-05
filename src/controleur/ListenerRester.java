package controleur;

import modele.Jardinier;
import vue.PanneauControle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerRester implements ActionListener {

    Jardinier jardinier;

    PanneauControle pc;


    public ListenerRester(Jardinier j , PanneauControle p) {
        pc =p;
        jardinier = j;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        jardinier.setMoving(false);
        jardinier.setSelected(false);
        jardinier.setPlanter(false);
        jardinier.setDesherber(false);
        jardinier.setRecolter(false);
        pc.updatePanneau();
    }

    public void setJardinier(Jardinier j) {
        this.jardinier =j;
    }
}

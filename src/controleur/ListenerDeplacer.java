package controleur;

import modele.Jardinier;
import vue.PanneauJardinier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDeplacer implements ActionListener {

    Jardinier jardinier;
    PanneauJardinier panneauJardinier;


    public ListenerDeplacer(Jardinier j, JButton d , PanneauJardinier panneauJardinier){
        jardinier=j;
        this.panneauJardinier = panneauJardinier;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       // deplacer.setBackground(Color.GREEN);

        jardinier.setMoving(true);
        jardinier.setPlanter(false);
        jardinier.setRecolter(false);
        jardinier.setDesherber(false);
        panneauJardinier.update(jardinier);
    }

    public void setJardinier(Jardinier j) {
        this.jardinier = j;
    }
}


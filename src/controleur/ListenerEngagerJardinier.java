package controleur;

import modele.Carte;
import vue.Fenetre;
import vue.PanneauBoutique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerEngagerJardinier implements ActionListener {

    Carte carte;

    PanneauBoutique panneauBoutique;

    Fenetre fenetre;

    JButton boutonEngagerJardinier;
    public ListenerEngagerJardinier(Carte carte , PanneauBoutique panneauBoutique , Fenetre fenetre , JButton boutonEngagerJardinier) {
        this.carte = carte;
        this.panneauBoutique = panneauBoutique;
        this.fenetre = fenetre;
        this.boutonEngagerJardinier = boutonEngagerJardinier;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        carte.engagerJardinier();
        fenetre.updateScore(true);
        if (carte.getScore() < carte.getPrixJardinier()){
            boutonEngagerJardinier.setBackground(Color.LIGHT_GRAY);
        }else {
            boutonEngagerJardinier.setBackground(Color.GREEN);
        }

    }
}

package vue;

import controleur.*;
import modele.*;

import javax.swing.*;
import java.awt.*;

public class PanneauJardinier extends JPanel {

    Jardinier jardinier;

    Carte carte;

    JButton deplacer;
    JButton planter;
    JButton recolter;
    JButton rester;
    JButton desherber;


    ListenerDeplacer listenerDeplacer;

    ListenerPlanter listenerPlanter;

    ListenerRecolter listenerRecolter;

    ListenerRester listenerRester;

    ListenerDesherber listenerDesherber;

    JPanel panneau;

    PanneauControle pc;
    public PanneauJardinier(Carte c, Jardinier j , PanneauControle panneauControle, int largeur , int hauteur) {
        jardinier = j;
        carte =c;
        pc = panneauControle;
        panneau = new JPanel();
        panneau.setPreferredSize(new Dimension(largeur / 3, hauteur));
       // JLabel nom = new JLabel(jardinier.getId());
        deplacer = new JButton("Deplacer");
        planter = new JButton("Planter");
        recolter = new JButton("Recolter");
        rester = new JButton("Rester");
        desherber = new JButton("Desherber");
        desherber.setHorizontalAlignment(SwingConstants.CENTER);


        JPanel boutons = new JPanel();
        boutons.setLayout(new GridLayout(5,1 , 10, 10));
        listenerDeplacer = new ListenerDeplacer(jardinier , deplacer , this);
        deplacer.addActionListener(listenerDeplacer);
        deplacer.setBackground(Color.WHITE);
        deplacer.setFocusPainted(false); // pour pas avoir un rectangle autour du texte du JButton
        listenerPlanter = new ListenerPlanter(jardinier , this);
        planter.addActionListener(listenerPlanter);
        planter.setBackground(Color.WHITE);
        planter.setFocusPainted(false);
        listenerRecolter = new ListenerRecolter(jardinier,carte , this);
        recolter.addActionListener(listenerRecolter);
        recolter.setBackground(Color.WHITE);
        recolter.setFocusPainted(false);
        listenerRester = new ListenerRester(jardinier, pc);
        rester.addActionListener(listenerRester);
        rester.setBackground(Color.WHITE);
        rester.setFocusPainted(false);
        listenerDesherber = new ListenerDesherber(jardinier, this);
        desherber.addActionListener(listenerDesherber);
        desherber.setBackground(Color.WHITE);
        desherber.setFocusPainted(false);


        boutons.add(deplacer);
        boutons.add(planter);
        boutons.add(recolter);
        boutons.add(rester);
        boutons.add(desherber);
        boutons.setBackground(new Color(101, 173, 101));
        panneau.setBackground(new Color(101, 173, 101));
        panneau.add(boutons);
        this.add(panneau);
        this.setBackground(new Color(101, 173, 101));
    }

    public void update(Jardinier j){
        jardinier = j;
        if (j.isBloque()) {
            // on bloque les boutons quand le jardinier est bloqué ( ie quand il desherbe )
            deplacer.setEnabled(false);
            planter.setEnabled(false);
            recolter.setEnabled(false);
            rester.setEnabled(false);
            desherber.setEnabled(false);
        }
        else {
            deplacer.setEnabled(true);
            planter.setEnabled(true);
            recolter.setEnabled(true);
            rester.setEnabled(true);
            desherber.setEnabled(true);

            if (j.desherbementEnCours()){
                desherber.setBackground(Color.GREEN);
                deplacer.setBackground(Color.WHITE);
                planter.setBackground(Color.WHITE);
                recolter.setBackground(Color.WHITE);
            }
            else if (j.isMoving()) {
                deplacer.setBackground(Color.GREEN);
                planter.setBackground(Color.WHITE);
                recolter.setBackground(Color.WHITE);
                desherber.setBackground(Color.WHITE);
            } else if (j.getPlanter()) {
                planter.setBackground(Color.GREEN);
                deplacer.setBackground(Color.WHITE);
                recolter.setBackground(Color.WHITE);
                desherber.setBackground(Color.WHITE);

            } else if (j.recolter()) {
                recolter.setBackground(Color.GREEN);
                deplacer.setBackground(Color.WHITE);
                planter.setBackground(Color.WHITE);
                desherber.setBackground(Color.WHITE);
            } else {

                planter.setBackground(Color.WHITE);
                deplacer.setBackground(Color.WHITE);
                recolter.setBackground(Color.WHITE);
                desherber.setBackground(Color.WHITE);
            }
            listenerDeplacer.setJardinier(j);
            listenerRester.setJardinier(j);
            listenerRecolter.setJardnier(j);
            listenerPlanter.setJardinier(j);
            listenerDesherber.setJardinier(j);
            panneau.revalidate();
            panneau.repaint();
        }
        this.repaint();
        this.revalidate();
    }




}

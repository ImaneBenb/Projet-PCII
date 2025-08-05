package vue;

import modele.Carte;
import modele.Fleur;
import modele.Jardinier;

import javax.swing.*;
import java.awt.*;

public class PanneauControle extends JPanel {


    private int largeur;

    private int hauteur;
    private JLabel titre;

    private JPanel panneauControle;

    private JPanel panneauFleur;

    private PanneauJardinier panneauJardinier;

    private JLabel nomFleur;
    private JProgressBar progress;


    private PanneauBoutique panneauBoutique;
    private Carte carte;

    private JPanel scorePanel;
    private JProgressBar progressScore;


    Fenetre fenetre;




    public PanneauControle(int l, int h, Carte c, Fenetre f) {

        fenetre = f;
        largeur = l;
        hauteur = h;
        carte = c;
        this.setPreferredSize(new Dimension(largeur / 3, hauteur));
        // on utilise un box layout pour avoir le panneau de controle des unite et la boutique l'une au dessus de l'autre


        panneauControle = new JPanel();
        progressScore = new JProgressBar(0, carte.getScoreFinal());
        progressScore.setValue(carte.getScore());
        progressScore.setForeground(Color.RED);
        progressScore.setStringPainted(true);
        progressScore.setSize(largeur/3, 100);

        panneauControle.setPreferredSize(new Dimension(largeur / 3, hauteur / 3));
        panneauControle.setBackground(new Color(101, 173, 101));

        this.setLayout(new BorderLayout());

        // Initialize scorePanel before adding components to it
        scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scorePanel.setBackground(new Color(101, 173, 101));
        scorePanel.add(new JLabel("SCORE "));
        scorePanel.add(progressScore);



        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(101, 173, 101));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));


        centerPanel.add(scorePanel);

        titre = new JLabel("Panneau de contrôle");
        titre.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        titre.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(titre);

        panneauControle = new JPanel();
        panneauControle.setPreferredSize(new Dimension(largeur / 3, hauteur / 3));
        panneauControle.setBackground(new Color(101, 173, 101));
        centerPanel.add(panneauControle);

        panneauBoutique = new PanneauBoutique(largeur, hauteur, carte.getBoutique(), carte, fenetre);
        centerPanel.add(panneauBoutique);

        this.add(centerPanel, BorderLayout.CENTER);


        panneauFleur = new JPanel();
        nomFleur = new JLabel();
        progress = new JProgressBar(0, 100);
        progress.setBounds(40, 40, 165, 30);
        progress.setValue(0);
        progress.setStringPainted(true);
        progress.setForeground(Color.YELLOW);
        progress.setSize(250, 150);
        panneauFleur.setPreferredSize(new Dimension(largeur / 3, hauteur));
        panneauFleur.setBackground(new Color(101, 173, 101));
        panneauFleur.add(nomFleur);
        panneauFleur.add(progress);

        panneauJardinier = new PanneauJardinier(carte, null, this, largeur, hauteur);


    }


    public void updatePanneau() {
        panneauControle.removeAll();
        //jardinier
        for (Jardinier j : carte.getListJardinier()) {
            if (j.isSelected()) {
                panneauJardinier.update(j);
                panneauControle.add(panneauJardinier);


            }
        }
        for (Fleur f : carte.getListFleurs()) {
            if (f.isSelected()) {
                updatePanneauFleur(f);
                panneauControle.add(panneauFleur);

            }
        }
        panneauControle.repaint();
        this.repaint();
    }

    public void updateInventaire() {
        panneauBoutique.updateInventaire();
        panneauBoutique.repaint();
        panneauBoutique.revalidate();
    }

    public void updatePanneauFleur(Fleur f) {
        nomFleur.setText("Fleur ");
        progress.setValue(f.getInit());
        if (f.getInit() >= f.getRecolte() && f.getInit() < f.getFanee()) {
            progress.setForeground(Color.GREEN);
        } else if (f.getInit() >= 90) {
            progress.setForeground(Color.RED);
        }

    }

    public void updateScore() {
        progressScore.setValue(carte.getScore());
        // Définir la couleur de la barre de progression en fonction de la valeur du score
        float ratio = (float) carte.getScore() / carte.getScoreFinal() * 100;
        if (ratio < 25) {
            progressScore.setForeground(Color.RED);
        } else if (ratio < 50) {
            progressScore.setForeground(Color.ORANGE);
        } else if (ratio < 75) {
            progressScore.setForeground(Color.YELLOW);
        } else {
            progressScore.setForeground(Color.GREEN);
        }
    }

}

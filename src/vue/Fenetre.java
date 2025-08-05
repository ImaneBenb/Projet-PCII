package vue;

import controleur.ListenerCarte;
import modele.Carte;
import modele.CountDownTimer;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    private final int largeur = 1400;
    private final int hauteur = 1000;

    PanneauControle panneauControle;

    Carte carte;
    VueCarte vueCarte;

    JPanel scorePanel;
    CountDownTimer cdt;
    JLabel scoreInsuffisant;



    JPanel jeuPerdu;

    JProgressBar progress;

    public Fenetre() {
        cdt = new CountDownTimer();
        carte = new Carte();
        this.setTitle("Jardinage");
        this.setSize(largeur, hauteur);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        panneauControle = new PanneauControle(largeur, hauteur,carte,this);
        this.add( panneauControle, BorderLayout.EAST);

        scorePanel = new JPanel();
        scorePanel.setPreferredSize(new Dimension(largeur, hauteur/40));

        progress = new JProgressBar(0, cdt.getMaxTime());
        //progress.setBounds(40,40,165,30);
        progress.setValue(0);
        progress.setStringPainted(true);
        progress.setForeground(Color.gray);
        progress.setPreferredSize(new Dimension(largeur, hauteur/40));
        progress.setString("Temps restant : " + cdt.getTempsRestant());
        scorePanel.add(progress);



        this.add(scorePanel, BorderLayout.SOUTH);
        scoreInsuffisant = new JLabel("SCORE INSIFFISANT POUR PLANTER GRAINE ");
        scoreInsuffisant.setForeground(Color.RED);



        jeuPerdu = new JPanel();
        jeuPerdu.setLayout(new BorderLayout());
        JLabel labelPerdu = new JLabel("JEU PERDU");
        labelPerdu.setFont(new Font("Arial", Font.BOLD, 50));
        labelPerdu.setHorizontalAlignment(SwingConstants.CENTER);
        jeuPerdu.add(labelPerdu , BorderLayout.CENTER);


        vueCarte = new VueCarte(this , panneauControle, largeur, hauteur, carte);
        ListenerCarte listenerCarte = new ListenerCarte(carte , panneauControle ,this, vueCarte);
        vueCarte.addMouseListener(listenerCarte);
        (new Redessine(this)).start();






        this.add(vueCarte, BorderLayout.WEST);

        this.setVisible(true);

    }

    public void afficheMessageFinPartie(String message) {
        // Supprime tous les composants existants de la fenêtre
        getContentPane().removeAll();

        // Crée un JLabel avec le message de fin de partie
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Change la police du texte
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement

        // Crée un conteneur pour contenir le JLabel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(messageLabel); // Ajoute le JLabel au conteneur

        // Ajoute le conteneur au centre de la fenêtre
        getContentPane().add(panel, BorderLayout.CENTER);

        // Revalide la disposition pour refléter les changements
        revalidate();
        repaint();
    }

    public void updateScore(boolean validScore) {
        if (validScore) {
            panneauControle.updateScore();

            // Vérifie si le score maximum est atteint et affiche le message de fin de partie si c'est le cas
            if (carte.partieGagnee()) {
                afficheMessageFinPartie("VOUS AVEZ GAGNE LA PARTIE !");
            }
        } else {
            scorePanel.add(scoreInsuffisant);
        }
    }

    public void effacerMessageErreur(){
        scorePanel.remove(scoreInsuffisant);
        scorePanel.repaint();
        scorePanel.revalidate();

    }




    public void updateTime() {
       progress.setString("Temps restant : " + cdt.getTempsRestant());
        progress.setValue(cdt.getCourentTime());
        if (cdt.getCourentTime() >= cdt.getMaxTime()){
            getContentPane().removeAll();
            getContentPane().add(jeuPerdu);
        }
    }


    public void updateColor() {
        if (cdt.getCourentTime() < 60) {
            progress.setForeground(Color.gray);
        }
        else if(cdt.getCourentTime() >= 60 && cdt.getCourentTime() < 100) {
            progress.setForeground(Color.ORANGE);
        }
        else if (cdt.getCourentTime() >= 100) {
            progress.setForeground(Color.RED);
        }
    }
}

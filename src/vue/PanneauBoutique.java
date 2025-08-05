package vue;

import controleur.*;
import modele.*;

import javax.swing.*;
import java.awt.*;

public class PanneauBoutique extends JPanel {

    Image rose = new ImageIcon(this.getClass().getResource("/images/rose.png")).getImage();
    Image tulipe = new ImageIcon(this.getClass().getResource("/images/tulip.png")).getImage();
    Image tournesol = new ImageIcon(this.getClass().getResource("/images/sunflower.png")).getImage();
    Image flower_blue = new ImageIcon(this.getClass().getResource("/images/flower_blue.png")).getImage();
    Image muguet = new ImageIcon(this.getClass().getResource("/images/muguet.png")).getImage();

    JLabel nbRose;
    JLabel nbTulipe;
    JLabel nbTournesol;
    JLabel nbFlowerBlue;
    JLabel nbMuguet;

    int tailleCaseInventaire;


    int tailleCaseBouquet;
    JPanel inventaire;





    JPanel bouquet;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;

    JButton retirerBouquet1;
    JButton retirerBouquet2;
    JButton retirerBouquet0;

    JButton vendreBouquet;
    JButton engagerJardinier;

    JPanel bouquetFleur1;
    JPanel bouquetFleur2;
    JPanel bouquetFleur3;



    Boutique boutique;

    Fenetre fenetre;


    JPanel engagerJardinierPanel;
    JPanel messageErreur;
    JLabel erreurJardinier;

    public PanneauBoutique(int largeur , int hauteur , Boutique b ,Carte carte, Fenetre f) {
        this.boutique = b;
        nbFlowerBlue = new JLabel("Nbre : 0" );
        nbMuguet = new JLabel("Nbre : 0" );
        nbRose = new JLabel("Nbre : 0" );
        nbTulipe = new JLabel("Nbre : 0" );
        nbTournesol = new JLabel("Nbre : 0" );
        this.fenetre = f;


        this.setPreferredSize(new Dimension(largeur / 3, 2*hauteur/3));
        this.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel nomBoutique = new JLabel("Boutique");
        nomBoutique.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        nomBoutique.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(nomBoutique);

        inventaire = new JPanel();
        inventaire.setLayout(new GridLayout(1, 5));
        tailleCaseInventaire = 60;
        tailleCaseBouquet = 110;
        inventaire.setPreferredSize(new Dimension(largeur/3 , hauteur/4));
        // case0 de l'inventaire : rose
        // lambda expression d'un JPannel
        JPanel pannelRose = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(rose, 0, 0, tailleCaseInventaire, tailleCaseInventaire, this);
            }
        };
        pannelRose.setPreferredSize(new Dimension(tailleCaseInventaire, tailleCaseInventaire));
        JPanel box1 = new JPanel();
        box1.setLayout(new FlowLayout());
        JLabel nomRose = new JLabel(" Rose ");
        nomRose.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        nomRose.setHorizontalAlignment(SwingConstants.CENTER);
        box1.add(nomRose);
        box1.add(pannelRose);
        JLabel prixRose = new JLabel("Prix : " + Rose.getPrix_fleur() );
        prixRose.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        box1.add(prixRose);
        JLabel prix_graine_rose = new JLabel("Prix graine : " + Rose.getPrix_graine());
        prix_graine_rose.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        box1.add(prix_graine_rose);
        box1.add(nbRose);
        b1 = new JButton("Ajouter");
        b1.setBackground(Color.LIGHT_GRAY);
        // b1.setBackground(new Color(138, 206, 131));
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.addActionListener(new ListenerAjouterRoseBouquet(boutique, this));
        box1.add(b1);
        box1.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        inventaire.add(box1);


        // case 2
        JPanel pannelTulip = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(tulipe, 0, 0, tailleCaseInventaire, tailleCaseInventaire, this);
            }
        };
        pannelTulip.setPreferredSize(new Dimension(tailleCaseInventaire, tailleCaseInventaire));
        JPanel box2 = new JPanel();
        box2.setLayout(new FlowLayout());
        JLabel nomTulipe = new JLabel("Tulipe");
        nomTulipe.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        nomTulipe.setHorizontalAlignment(SwingConstants.CENTER);
        box2.add(nomTulipe);
        box2.add(pannelTulip);
        JLabel prixTulipe = new JLabel("Prix : " + Tulipe.getPrix_fleur() );
        prixTulipe.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        JLabel prixGraineTulipe = new JLabel("Prix graine : " + Tulipe.getPrix_graine() );
        prixGraineTulipe.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        box2.add(prixTulipe);
        box2.add(prixGraineTulipe);
        box2.add(nbTulipe);
        b2 = new JButton("Ajouter");
        b2.setBackground(Color.LIGHT_GRAY);
      //  b2.setBackground(new Color(138, 206, 131));
        b2.setForeground(Color.WHITE);
        b2.setFocusPainted(false);
        b2.setFont(new Font("Tahoma", Font.BOLD, 12));
        b2.addActionListener(new ListenerAjouterTulipeBouquet(boutique, this));
        box2.add(b2);
        box2.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        inventaire.add(box2);


       // case 3
        JPanel pannelTournesol = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(tournesol, 0, 0, tailleCaseInventaire, tailleCaseInventaire, this);

            }
        };
        pannelTournesol.setPreferredSize(new Dimension(tailleCaseInventaire, tailleCaseInventaire));
        JPanel box3 = new JPanel();
        box3.setLayout(new FlowLayout());
        JLabel nomTournesol = new JLabel("Tournesol");
        nomTournesol.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        nomTournesol.setHorizontalAlignment(SwingConstants.CENTER);
        box3.add(nomTournesol);
        box3.add(pannelTournesol);
        JLabel prixTournesol = new JLabel("Prix : " + Tournesol.getPrix_fleur() );
        prixTournesol.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        box3.add(prixTournesol);
        JLabel prixGraineTournesol = new JLabel("Prix graine : " + Tournesol.getPrix_graine() );
        prixGraineTournesol.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        box3.add(prixGraineTournesol);
        box3.add(nbTournesol);
        b3 = new JButton("Ajouter");
        b3.setBackground(Color.LIGHT_GRAY);
      //  b3.setBackground(new Color(138, 206, 131));
        b3.setForeground(Color.WHITE);
        b3.setFocusPainted(false);
        b3.setFont(new Font("Tahoma", Font.BOLD, 12));
        b3.addActionListener(new ListenerAjouterTournesolBouquet(boutique, this));
        box3.add(b3);
        box3.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        inventaire.add(box3);




        // case 4
        JPanel pannelFlowerBlue = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(flower_blue, 0, 0, tailleCaseInventaire, tailleCaseInventaire, this);
            }
        };
        pannelFlowerBlue.setPreferredSize(new Dimension(tailleCaseInventaire, tailleCaseInventaire));
        JPanel box4 = new JPanel();
        box4.setLayout(new FlowLayout());
        JLabel nomFleurBleue = new JLabel("Fleur bleue");
        nomFleurBleue.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        nomFleurBleue.setHorizontalAlignment(SwingConstants.CENTER);
        box4.add(nomFleurBleue);
        box4.add(pannelFlowerBlue);
        JLabel prixFleurBleue = new JLabel("Prix : " + FleurBleue.getPrix_fleur());
        prixFleurBleue.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        box4.add(prixFleurBleue);
        JLabel prixGraineFleurBleue = new JLabel("Prix graine : " + FleurBleue.getPrix_graine());
        prixGraineFleurBleue.setFont(new Font(Font.SERIF, Font.PLAIN, 12));
        box4.add(prixGraineFleurBleue);
        box4.add(nbFlowerBlue);
        b4 = new JButton("Ajouter");
        b4.setBackground(Color.LIGHT_GRAY);
       // b4.setBackground(new Color(138, 206, 131));
        b4.setForeground(Color.WHITE);
        b4.setFocusPainted(false);
        b4.setFont(new Font("Tahoma", Font.BOLD, 12));
        b4.addActionListener(new ListenerAjouterFleurBleueBouquet(boutique, this));
        box4.add(b4);
        box4.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        inventaire.add(box4);




        // case 5
        JPanel pannelMuguet = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(muguet, 0, 0, tailleCaseInventaire, tailleCaseInventaire, this);

            }
        };
        pannelMuguet.setPreferredSize(new Dimension(tailleCaseInventaire, tailleCaseInventaire));
        JPanel box5 = new JPanel();
        box5.setLayout(new FlowLayout());
        JLabel nomMuget = new JLabel("Muget");
        nomMuget.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        nomMuget.setHorizontalAlignment(SwingConstants.CENTER);
        box5.add(nomMuget);
        box5.add(pannelMuguet);
        JLabel prixMuguet = new JLabel("Prix : " + Muguet.getPrix_fleur());
        prixMuguet.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        JLabel prixGraineMuguet = new JLabel("Prix graine : " + Muguet.getPrix_graine());
        prixGraineMuguet.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        box5.add(prixMuguet);
        box5.add(prixGraineMuguet);
        box5.add(nbMuguet);
        b5 = new JButton("Ajouter");
        b5.setBackground(Color.LIGHT_GRAY);
       // b5.setBackground(new Color(138, 206, 131));
        b5.setForeground(Color.WHITE);
        b5.setFocusPainted(false);
        b5.setFont(new Font("Tahoma", Font.BOLD, 12));
        b5.addActionListener(new ListenerAjouterMuguetBouquet(boutique, this));
        box5.add(b5, BorderLayout.SOUTH);
        box5.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        inventaire.add(box5);
        inventaire.setPreferredSize(new Dimension(largeur/3, tailleCaseInventaire *3));
        this.add(inventaire);


        // le bouquet est composé de 3 fleurs
        JLabel bouquetLabel = new JLabel("Bouquet");
        bouquetLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.add(bouquetLabel);
        bouquet = new JPanel();
        bouquet.setLayout(new GridLayout(1, 3));
        bouquetFleur1 = new JPanel();
        bouquetFleur1.setPreferredSize(new Dimension(tailleCaseBouquet, tailleCaseBouquet));
        bouquetFleur2 = new JPanel();
        bouquetFleur2.setPreferredSize(new Dimension(tailleCaseBouquet, tailleCaseBouquet));
        bouquetFleur3 = new JPanel();
        bouquetFleur3.setPreferredSize(new Dimension(tailleCaseBouquet, tailleCaseBouquet));
        JPanel case0 = new JPanel();
        case0.setPreferredSize(new Dimension(tailleCaseBouquet+55, tailleCaseBouquet+55));
        case0.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        case0.add(new JLabel("Fleur 1"));
        case0.add(bouquetFleur1);
        retirerBouquet0 = new JButton("Retirer");
       retirerBouquet0.setBackground(Color.LIGHT_GRAY);
        // retirerBouquet0.setBackground(new Color(138, 206, 131));
        retirerBouquet0.setForeground(Color.WHITE);
        retirerBouquet0.setFocusPainted(false);
        retirerBouquet0.setFont(new Font("Tahoma", Font.BOLD, 12));
        retirerBouquet0.addActionListener(new ListenerEnleverFleurBouquet(boutique, this , 0));
        case0.add(retirerBouquet0);


        JPanel case1 = new JPanel();
        case1.setPreferredSize(new Dimension(tailleCaseBouquet+55, tailleCaseBouquet+55));
        case1.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        case1.add(new JLabel("Fleur 2"));
        case1.add(bouquetFleur2);
        retirerBouquet1 = new JButton("Retirer");
        retirerBouquet1.setBackground(Color.LIGHT_GRAY);
        //retirerBouquet1.setBackground(new Color(138, 206, 131));
        retirerBouquet1.setForeground(Color.WHITE);
        retirerBouquet1.setFocusPainted(false);
        retirerBouquet1.setFont(new Font("Tahoma", Font.BOLD, 12));
        retirerBouquet1.addActionListener(new ListenerEnleverFleurBouquet(boutique, this , 1));
        case1.add(retirerBouquet1);

        JPanel case2 = new JPanel();
        case2.setPreferredSize(new Dimension(tailleCaseBouquet+55, tailleCaseBouquet+55));
        case2.setBorder(BorderFactory.createLineBorder(new Color(138, 206, 131)));
        case2.add(new JLabel("Fleur 3"));
        case2.add(bouquetFleur3);
        retirerBouquet2 = new JButton("Retirer");
        retirerBouquet2.setBackground(Color.LIGHT_GRAY);
        //retirerBouquet2.setBackground(new Color(138, 206, 131));
        retirerBouquet2.setForeground(Color.WHITE);
        retirerBouquet2.setFocusPainted(false);
        retirerBouquet2.setFont(new Font("Tahoma", Font.BOLD, 12));
        retirerBouquet2.addActionListener(new ListenerEnleverFleurBouquet(boutique, this , 2));
        case2.add(retirerBouquet2);

        bouquet.add(case0);
        bouquet.add(case1);
        bouquet.add(case2);




        this.add(bouquet);

        vendreBouquet = new JButton("Vendre le bouquet");
        vendreBouquet.setBackground(Color.LIGHT_GRAY);
      //  vendreBouquet.setBackground(new Color(138, 206, 131));
        vendreBouquet.setForeground(Color.WHITE);
        vendreBouquet.setFocusPainted(false);
        vendreBouquet.setFont(new Font("Tahoma", Font.BOLD, 12));
        vendreBouquet.addActionListener(new ListenerVendre(boutique, this , fenetre));
        this.add(vendreBouquet);

        engagerJardinierPanel = new JPanel();
        engagerJardinierPanel.setPreferredSize(new Dimension(largeur/3, hauteur/10));
        engagerJardinierPanel.setBackground(Color.WHITE);

        Image imageJardinier = new ImageIcon(this.getClass().getResource("/images/jardinier.png")).getImage();
        JPanel imageJardinierPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(imageJardinier, 0, 0, 100, 100, this);

            }
        };
        imageJardinierPanel.setPreferredSize(new Dimension(100, 100));
        engagerJardinierPanel.add(imageJardinierPanel);
        engagerJardinier = new JButton( "Engager un jardinier\n prix :" + carte.getPrixJardinier());
        engagerJardinier.setBackground(Color.LIGHT_GRAY);
        engagerJardinier.setForeground(Color.WHITE);
        engagerJardinier.setFocusPainted(false);
        engagerJardinier.setFont(new Font("Tahoma", Font.BOLD, 12));
        engagerJardinier.addActionListener(new ListenerEngagerJardinier(carte, this , fenetre , engagerJardinier));

        engagerJardinierPanel.add(engagerJardinier);
        this.add(engagerJardinierPanel);


      //  this.add(p);
    }

    public JPanel newImageTulipe(int t){
        JPanel pannelTulipe = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(tulipe, 0, 0, t, t, this);
            }
        };
        pannelTulipe.setPreferredSize(new Dimension(t, t));
        return pannelTulipe;
    }

    public JPanel newImageTournesol(int t){
        JPanel pannelTournesol = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(tournesol, 0, 0, t, t, this);
            }
        };
        pannelTournesol.setPreferredSize(new Dimension(t, t));
        return pannelTournesol;
    }
    public JPanel newImageFleurBleue(int t){
        JPanel pannelFlowerBlue = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(flower_blue, 0, 0, t, t, this);
            }
        };
        pannelFlowerBlue.setPreferredSize(new Dimension(t, t));
        return pannelFlowerBlue;
    }

    public JPanel newImageMuguet(int t){
        JPanel pannelMuguet = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(muguet, 0, 0, t, t, this);
            }
        };
        pannelMuguet.setPreferredSize(new Dimension(t, t));
        return pannelMuguet;
    }

    public JPanel newImageRose(int t){
        JPanel pannelRose = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(rose, 0, 0, t, t, this);
            }
        };
        pannelRose.setPreferredSize(new Dimension(t, t));
        return pannelRose;
    }

    // mise à jour de l'inventaire

    public void updateInventaire(){
        if (boutique.getNbrRose() > 0){
           b1.setBackground(new Color(138, 206, 131));
        }else {
            b1.setBackground(Color.LIGHT_GRAY);
        }
        if (boutique.getNbrTulipe() > 0){
            b2.setBackground(new Color(138, 206, 131));
        }else {
            b2.setBackground(Color.LIGHT_GRAY);
        }
        if (boutique.getNbrTournesol() > 0){
            b3.setBackground(new Color(138, 206, 131));
        }else {
            b3.setBackground(Color.LIGHT_GRAY);

        }
        if (boutique.getNbrFleurBleue() > 0){
            b4.setBackground(new Color(138, 206, 131));
        }else {
            b4.setBackground(Color.LIGHT_GRAY);
        }
        if (boutique.getNbrMuguet() > 0){
            b5.setBackground(new Color(138, 206, 131));
        }else {
            b5.setBackground(Color.LIGHT_GRAY);
        }


        nbRose.setText("Nbre : " + boutique.getNbrRose() );
        nbTulipe.setText("Nbre : " + boutique.getNbrTulipe() );
        nbTournesol.setText("Nbre : " + boutique.getNbrTournesol() );
        nbFlowerBlue.setText("Nbre : " + boutique.getNbrFleurBleue() );
        nbMuguet.setText("Nbre : " + boutique.getNbrMuguet() );
    }

    public void ajouterRoseBouquet(int i) {
        switch (i) {
            case 0:
                bouquetFleur1.removeAll();
                bouquetFleur1.add(newImageRose(tailleCaseBouquet));
                retirerBouquet0.setBackground(new Color(138, 206, 131));


                break;
            case 1:
                bouquetFleur2.removeAll();
                bouquetFleur2.add(newImageRose(tailleCaseBouquet));
                retirerBouquet1.setBackground(new Color(138, 206, 131));
                break;
            case 2:
                bouquetFleur3.removeAll();
                bouquetFleur3.add(newImageRose(tailleCaseBouquet));
                retirerBouquet2.setBackground(new Color(138, 206, 131));
                vendreBouquet.setBackground(new Color(138, 206, 131));
                break;

        }
        updateInventaire();
    }
    public void ajouterTulipeBouquet(int i) {
        switch (i) {
            case 0:
                bouquetFleur1.removeAll();
                bouquetFleur1.add(newImageTulipe(tailleCaseBouquet));
                retirerBouquet0.setBackground(new Color(138, 206, 131));
                break;
            case 1:
                bouquetFleur2.removeAll();
                bouquetFleur2.add(newImageTulipe(tailleCaseBouquet));
                retirerBouquet1.setBackground(new Color(138, 206, 131));
                break;
            case 2:
                bouquetFleur3.removeAll();
                bouquetFleur3.add(newImageTulipe(tailleCaseBouquet));
                retirerBouquet2.setBackground(new Color(138, 206, 131));
                vendreBouquet.setBackground(new Color(138, 206, 131));
                break;

        }
        updateInventaire();
    }
    public void ajouterTournesolBouquet(int i) {
        switch (i) {
            case 0:
                bouquetFleur1.removeAll();
                bouquetFleur1.add(newImageTournesol(tailleCaseBouquet));
                retirerBouquet0.setBackground(new Color(138, 206, 131));
                break;
            case 1:
                bouquetFleur2.removeAll();
                bouquetFleur2.add(newImageTournesol(tailleCaseBouquet));
                retirerBouquet1.setBackground(new Color(138, 206, 131));
                break;
            case 2:
                bouquetFleur3.removeAll();
                bouquetFleur3.add(newImageTournesol(tailleCaseBouquet));
                retirerBouquet2.setBackground(new Color(138, 206, 131));
                vendreBouquet.setBackground(new Color(138, 206, 131));
                break;

        }
        updateInventaire();
    }
    public void ajouterFleurBleueBouquet(int i) {
        switch (i) {
            case 0:
                bouquetFleur1.removeAll();
                bouquetFleur1.add(newImageFleurBleue(tailleCaseBouquet));
                retirerBouquet0.setBackground(new Color(138, 206, 131));
                break;
            case 1:
                bouquetFleur2.removeAll();
                bouquetFleur2.add(newImageFleurBleue(tailleCaseBouquet));
                retirerBouquet1.setBackground(new Color(138, 206, 131));
                break;
            case 2:
                bouquetFleur3.removeAll();
                bouquetFleur3.add(newImageFleurBleue(tailleCaseBouquet));
                retirerBouquet2.setBackground(new Color(138, 206, 131));
                vendreBouquet.setBackground(new Color(138, 206, 131));
                break;

        }
        updateInventaire();
    }

    // en parametre a quelle nombre est associé le muguet dans le bouquet
    public void ajouterMuguetBouquet(int i) {
        switch (i) {
            case 0:
                bouquetFleur1.removeAll();
                bouquetFleur1.add(newImageMuguet(tailleCaseBouquet));
                retirerBouquet0.setBackground(new Color(138, 206, 131));
                break;
            case 1:
                bouquetFleur2.removeAll();
                bouquetFleur2.add(newImageMuguet(tailleCaseBouquet));
                retirerBouquet1.setBackground(new Color(138, 206, 131));
                break;
            case 2:
                bouquetFleur3.removeAll();
                bouquetFleur3.add(newImageMuguet(tailleCaseBouquet));
                retirerBouquet2.setBackground(new Color(138, 206, 131));
                vendreBouquet.setBackground(new Color(138, 206, 131));
                break;

        }
        updateInventaire();
    }

    // on met à jour le bouquet
    public void updateBouquet(){
        bouquetFleur1.removeAll();
        bouquetFleur2.removeAll();
        bouquetFleur3.removeAll();
        retirerBouquet0.setBackground(Color.LIGHT_GRAY);
        retirerBouquet1.setBackground(Color.LIGHT_GRAY);
        retirerBouquet2.setBackground(Color.LIGHT_GRAY);
        vendreBouquet.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < boutique.getBouquet().size(); i++) {
            Fleur f = boutique.getBouquet().get(i);
            if (f instanceof Rose) {
                ajouterRoseBouquet(i);
            } else if (f instanceof Tulipe) {
                ajouterTulipeBouquet(i);
            } else if (f instanceof Tournesol) {
                ajouterTournesolBouquet(i);
            } else if (f instanceof FleurBleue) {
                ajouterFleurBleueBouquet(i);
            } else if (f instanceof Muguet) {
                ajouterMuguetBouquet(i);
            }
        }
        updateInventaire();
    }

    public void updateEngagerJardinier() {
        if (boutique.engagerJardinier()) {
            engagerJardinier.setBackground(new Color(138, 206, 131));
        } else {
            engagerJardinier.setBackground(Color.LIGHT_GRAY);
        }
    }
}

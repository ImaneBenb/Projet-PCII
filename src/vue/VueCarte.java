package vue;


import controleur.*;
import modele.*;

import javax.swing.*;
import java.awt.*;

public class VueCarte extends JPanel {



    Carte carte;
    private Image jardinierImage;
    private Image fleurFaneeImage;
    private Image arrosoirImage;
    private Image rateauImage;
    private int RAYON;
    // rayon qui va varier pendant l'animation
    private int RAYON_ANIMATION;

    private Color couleur = Color.BLUE;
    private int animationDelay = 10; // Délai entre chaque étape de l'animation
    private int animationSteps = 50; // Nombre d'étapes pour l'animation
    private int currentStep = 0; // Étape actuelle de l'animation
    private Timer timerDeplacement;

    private boolean clicEnCours = false;

    // images des fleurs
    private Image pousseImage;

    private Image rose;
    private Image tulipe;

    private Image tournesol;

    private Image flower_blue;

    private Image muguet;


    JPopupMenu popupMenu;
    JMenuItem itemPlanter;
    JMenuItem itemPlanter2;
    JMenuItem itemPlanter3;
    JMenuItem itemPlanter4;
    JMenuItem itemPlanter5;
    MenuListener ml;

    Fenetre fenetre;

    PanneauControle pc;




// animation pousse avec un timerDeplacement et l'arrosoir
    private Timer timerPousse;
    private int angleImage=0; // pour avoir une animation avec l'arrosoir
    private int variationAngle = -1;

    private Timer timerDesherbement;

    public VueCarte(Fenetre f , PanneauControle pc , int largeur , int hauteur , Carte c  ){
        fenetre =f;
        carte= c;
        this.pc = pc;
        this.setPreferredSize( new Dimension(2*largeur/3 , hauteur));
        // les images
        this.jardinierImage = new ImageIcon(this.getClass().getResource("/images/jardinier.png")).getImage();
        this.fleurFaneeImage = new ImageIcon(this.getClass().getResource("/images/fleur_fanee.png")).getImage();
        this.pousseImage =  new ImageIcon(this.getClass().getResource("/images/pousse.png")).getImage();
        this.arrosoirImage = new ImageIcon(this.getClass().getResource("/images/arrosoir.png")).getImage();
        this.rateauImage = new ImageIcon(this.getClass().getResource("/images/rateau.png")).getImage();
        rose = new ImageIcon(this.getClass().getResource("/images/rose.png")).getImage();
        tulipe = new ImageIcon(this.getClass().getResource("/images/tulip.png")).getImage();
        tournesol = new ImageIcon(this.getClass().getResource("/images/sunflower.png")).getImage();
        flower_blue = new ImageIcon(this.getClass().getResource("/images/flower_blue.png")).getImage();
        muguet = new ImageIcon(this.getClass().getResource("/images/muguet.png")).getImage();


        // le popup menu
        popupMenu = new JPopupMenu("Choix fleur");
        itemPlanter = new JMenuItem("Rose");

        itemPlanter2 = new JMenuItem("Tulipe");
        itemPlanter3 = new JMenuItem("Tournesol");
        itemPlanter4 = new JMenuItem("Muguet");
        itemPlanter5 = new JMenuItem("fleurBleue");

        popupMenu.add(itemPlanter);
        popupMenu.add(itemPlanter2);
        popupMenu.add(itemPlanter3);
        popupMenu.add(itemPlanter4);
        popupMenu.add(itemPlanter5);
         ml = new MenuListener(carte,this , fenetre, pc,0,0);
        itemPlanter.setActionCommand("Rose");
        itemPlanter.addActionListener(ml);
        itemPlanter2.setActionCommand("Tulipe");
        itemPlanter2.addActionListener(ml);
        itemPlanter3.setActionCommand("Tournesol");
        itemPlanter3.addActionListener(ml);
        itemPlanter4.setActionCommand("Muguet");
        itemPlanter4.addActionListener(ml);
        itemPlanter5.setActionCommand("FleurBleue");
        itemPlanter5.addActionListener(ml);

        RAYON = carte.getListJardinier().get(0).getRayon();
        RAYON_ANIMATION =carte.getListJardinier().get(0).getRayon();
        // Initialiser le timerDeplacement pour l'animation de deplacement
        timerDeplacement = new Timer(animationDelay, e -> {
            if (clicEnCours) {
                if (currentStep < animationSteps) {
                    // Augmenter progressivement le rayon du cercle jusqu'à une taille maximale
                    RAYON_ANIMATION = RAYON_ANIMATION + (80 / animationSteps);
                    currentStep++;
                } else {
                    // Rétrécir progressivement le cercle jusqu'à sa taille initiale
                    if (RAYON_ANIMATION > 80) {
                        RAYON_ANIMATION = RAYON_ANIMATION - (80 / animationSteps);
                    } else {
                        // Arrêter l'animation lorsque le cercle a retrouvé sa taille initiale
                        clicEnCours = false;
                        timerDeplacement.stop();
                        RAYON_ANIMATION = 80; // Réinitialiser le rayon à sa taille initiale
                        currentStep = 0; // Réinitialiser l'étape actuelle
                    }
                }
                repaint(); // Redessiner pour afficher les changements
            }
        });

        timerPousse = new Timer(50, e -> {
                if (angleImage ==  -25){
                    variationAngle= 1;
                }
                 if (angleImage == 0){
                    variationAngle=-1;
                }
                angleImage += variationAngle;

        });
        timerDesherbement = new Timer(50, e -> {
            if (angleImage ==  -25){
                variationAngle= 1;
            }
            if (angleImage == 0){
                variationAngle=-1;
            }
            angleImage += variationAngle;

        });

    }

    // Méthode pour démarrer l'animation de déplacement
    public void demarrerAnimationDeplacement() {
        clicEnCours = true;
        timerDeplacement.start();
    }

    public void demarrerAnimationPlanter() {
        angleImage=0;
        variationAngle=1;
        timerPousse.start();
    }
    public void arreterAnimationPlanter(){
        boolean aucunePousseEnCours = true;
        for (int i=0;i<carte.getListFleurs().size();i++){
            if (carte.getListFleurs().get(i).enPousse()){
                aucunePousseEnCours = false;
            }
        }
        if (aucunePousseEnCours)
        timerPousse.stop();
    }

    public void demarrerAnimationDesherber() {
        angleImage=0;
        variationAngle=1;
        timerDesherbement.start();
    }
    public void arreterAnimationDesherber(){
        boolean aucunDesherbementEnCours = true;
        for (int i=0;i<carte.getListFleurs().size();i++){
            if (carte.getListFleurs().get(i).desherbementEnCours()){
                aucunDesherbementEnCours = false;
            }
        }
        if (aucunDesherbementEnCours)
        timerDesherbement.stop();
    }

    public void paintJardinier(Graphics g , Jardinier jardinier){


        int jardinierX = jardinier.getX();
        int jardinierY = jardinier.getY();

        // Dessiner le cercle avec un bord épais

        // Dessiner l'image du jardinier
        int imageX = jardinierX - RAYON/2;
        int imageY = jardinierY - RAYON/2;
         g.drawImage(jardinierImage, imageX, imageY,RAYON ,RAYON  ,this);

        if (jardinier.isSelected()) {
            g.setColor(couleur);
            g.drawOval(jardinierX - RAYON_ANIMATION, jardinierY - RAYON_ANIMATION, 2 * RAYON_ANIMATION, 2 * RAYON_ANIMATION);

            g.setColor(Color.BLACK);
            Graphics2D g2d = (Graphics2D) g;

            // Définissez la police en gras et 3x plus grande
            Font font = new Font("Helvetica", Font.BOLD, 16);
            g2d.setFont(font);

            Color marron = new Color(139, 69, 19); // Code RVB pour la couleur marron
            g2d.setColor(marron);
            g2d.drawString(jardinier.getId(), jardinierX - RAYON_ANIMATION /5, jardinierY - RAYON_ANIMATION - 2);

        }
        else{
            g.setColor(couleur);
            g.drawOval(jardinierX - RAYON, jardinierY - RAYON, 2 * RAYON, 2 * RAYON);

        }
    }

    public void paintFleur(Graphics g, Fleur f){
        int x = f.getX() ;
        int y = f.getY();
        if (f.estFanee()){
            g.drawImage(fleurFaneeImage, x-f.getTaille()/2, y-f.getTaille()/2, f.getTaille() , f.getTaille()  ,this);
        }
        else if (f.estRecoltable()) {
            if ( f instanceof Rose)
            g.drawImage(rose, x-f.getTaille()/2, y-f.getTaille()/2, f.getTaille(), f.getTaille(), this);
            else if ( f instanceof Tulipe)
            g.drawImage(tulipe, x-f.getTaille()/2, y-f.getTaille()/2, f.getTaille(), f.getTaille(), this);
            else if (f instanceof Tournesol)
            g.drawImage(tournesol, x-f.getTaille()/2, y-f.getTaille()/2, f.getTaille(), f.getTaille(), this);
            else if (f instanceof FleurBleue)
            g.drawImage(flower_blue, x-f.getTaille()/2, y-f.getTaille()/2, f.getTaille(), f.getTaille(), this);
            else if (f instanceof Muguet)
            g.drawImage(muguet, x-f.getTaille()/2, y-f.getTaille()/2, f.getTaille(), f.getTaille(), this);

        }
        else if (f.enPousse()) {
            // la fleur pousse
            g.drawImage(pousseImage, x-f.getTaille()/2, y-f.getTaille()/2, f.getTaille(), f.getTaille(), this);
        }
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i = 0; i< carte.getListJardinier().size() ; i++) {
            paintJardinier(g, (carte.getListJardinier()).get(i));
            carte.getListJardinier().get(i).desherbementEnCours();
        }
            for (Fleur f: carte.getListFleurs()){
                paintFleur(g,f);
                if (f.enPousse()){
                    animationPlanter(g,f.getX(),f.getY() , f.getTaille());
                }
                else if( f.desherbementEnCours()){
                    animationDesherber(g,f.getX(),f.getY() , f.getTaille());
                }
            }
    }

    public void addPopUpMenu(int x , int y){
        ml.setCordonnee(x,y);
        popupMenu.show(this, x, y);
    }



    public void animationPlanter(Graphics g ,  int x, int y, int taille){
        Graphics2D g2 = (Graphics2D)g;
        g2.rotate(Math.toRadians(angleImage), x, y-3*taille/2);
        g2.drawImage(arrosoirImage, x, y-3*taille/2, taille, taille, this);
        g2.rotate(Math.toRadians(-angleImage), x, y-3*taille/2);
    }

    public void animationDesherber(Graphics g ,  int x, int y, int taille){
        Graphics2D g2 = (Graphics2D)g;
        g2.rotate(Math.toRadians(angleImage), x, y-3*taille/2);
        g2.drawImage(rateauImage, x, y-2*taille/3, taille, taille, this);
        g2.rotate(Math.toRadians(-angleImage), x, y-3*taille/2);
    }




}

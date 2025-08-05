package modele;

public class Jardinier {
    private int x;
    private int y;

    public final static int RAYON=80;
    public static final int DELAI_DESHERBEMENT = 100; // Délai entre chaque mise à jour de position en millisecondes
    private int vitesse;
    private String id;




    private boolean selected ;
    private boolean ismoving;
    // quand le jardinier est en train de desherber
    private boolean desherber;
// savoir si le jardinier est bloqué : si il est en train de desherber
    private boolean bloque;

    // quand le jardinier est en train de récolter
    private boolean recolter;
    //quand le jardinier est en train de planter
    private boolean planter;

    private int destinationY;

    private int destinationX;


    public Jardinier(int x, int y, int vitesse, String id) {
        this.x = x;
        this.y = y;
        destinationX =x;
        destinationY=y;
        this.vitesse = vitesse;
        this.selected = false;
        this.ismoving = false;
        this.recolter = false;
        this.planter = false;
        this.desherber = false;
        this.bloque = false;
        this.id = id;

    }

    public String getId() {
        return id;
    }

    public boolean isBloque() {
        return bloque;
    }
    public void setBloque(boolean b) {
        this.bloque = b;
    }

    public boolean desherbementEnCours() {
        return this.desherber;
    }
    public void setDesherber(boolean b) {
        this.desherber = b;

    }
    // Vérifie si le jardinier a été cliqué
    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public void deplacerUnite() {
        // Calcul de la différence entre les positions actuelles et nouvelles
        if (selected && ismoving) {
            if (x==destinationX && y==destinationY){
                ismoving=false;
            }
            else {
                int newX = destinationX;
                int newY = destinationY;
                int deplacementX = newX - x;
                int deplacementY = newY - y;

                // Calcul de la distance totale à parcourir
                double distanceTotale = Math.sqrt(deplacementX * deplacementX + deplacementY * deplacementY);

                // Vérification si le jardinier doit réellement se déplacer
                if (distanceTotale <= vitesse) {
                    // Si la distance est inférieure ou égale à la vitesse, le jardinier se déplace directement à la nouvelle position
                    x = newX;
                    y = newY;
                    ismoving=false;


                } else {
                    // Sinon, calcul du ratio de déplacement en fonction de la vitesse maximale
                    double ratioDeplacement = vitesse / distanceTotale;

                    // Calcul du déplacement proportionnel selon le ratio
                    int deplacementXProportionnel = (int) (deplacementX * ratioDeplacement);
                    int deplacementYProportionnel = (int) (deplacementY * ratioDeplacement);

                    // Mise à jour des coordonnées du jardinier avec le déplacement proportionnel
                    x += deplacementXProportionnel;
                    y += deplacementYProportionnel;

                }
            }

        }
    }


    // Getters et setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDestinationX() { return destinationX;}

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestination(int x, int y) {
        destinationY=y;
        destinationX=x;
    }

    public boolean isMoving() { return ismoving;}

    public void setMoving(boolean b) { this.ismoving = b;}



    public boolean recolter() {return recolter;}
    public void setRecolter(boolean b) {
        this.recolter = b;
    }

    public int getRayon() {return RAYON;}


    public void setPlanter(boolean b) {
        this.planter = b;
    }
    public boolean getPlanter() {
        return planter;
    }

    public int getDelaiDesherbement() {
    return DELAI_DESHERBEMENT;
    }
}
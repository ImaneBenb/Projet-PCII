package modele;

public class Tournesol extends Fleur{

    public Tournesol(int x, int y ) {
        super(x,y);
        prix_fleur = 30;
        prix_graine = 15;
    }

    public static int getPrix_graine(){return 5;}

    public static int getPrix_fleur() {return 30;}
}

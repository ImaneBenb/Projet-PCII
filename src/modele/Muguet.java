package modele;

public class Muguet extends Fleur{

    public Muguet(int x, int y ) {
        super(x, y);
        prix_fleur = 13;
        prix_graine =8;
    }
    public static int getPrix_graine(){return 8;}

    public static int getPrix_fleur() {return 13;}
}

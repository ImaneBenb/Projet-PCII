package modele;

public class FleurBleue extends Fleur{


    public FleurBleue(int x, int y) {
        super(x, y);
        prix_fleur = 15;
        prix_graine = 5;
    }
    public static int getPrix_graine(){return 7;}

    public static int getPrix_fleur() {return 15;}


}

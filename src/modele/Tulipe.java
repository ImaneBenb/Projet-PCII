package modele;

public class Tulipe extends Fleur{


    public Tulipe(int x, int y ) {
        super(x, y);
        pasPousse = 2;
        prix_graine = 10;
        prix_fleur = 20;

    }
    public static int getPrix_graine(){return 6;}

    public static int getPrix_fleur() {return 20;}
}

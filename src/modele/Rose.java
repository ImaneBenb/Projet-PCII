package modele;

public class Rose extends Fleur{


    public Rose(int x, int y) {
        super(x, y);
        pasPousse = 3; // rose pousse plus vite
        prix_graine = 10;
        prix_fleur  = 30;
    }

    public static int getPrix_graine(){return 9;}

    public static int getPrix_fleur() {return 30;}


}

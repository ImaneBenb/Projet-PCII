package modele;

public class Fleur {

    //attributs

    protected int x;
    protected int y;
    protected static int prix_graine;
    protected static int prix_fleur;
    protected int id = 0;
    protected int init = 0;
    protected int pasPousse = 1;
    protected final int recolte = 20;
    protected final int fanee = 100;

    protected final int taille = 50;

    protected boolean selected;

    protected boolean estFanee;

    protected boolean enPousse;

    protected boolean recoltable;

    protected boolean desherbementEnCours;

    public Fleur(int x,int y  ){
        this.id = id;
        this.x = x;
        this.y = y;
        estFanee = false;
        enPousse = true;
        recoltable = false;
        selected = false;
        desherbementEnCours = false;
    }
    //méthodes


    public boolean estFanee() { return estFanee;}

    public int getFanee() {
        return fanee;
    }

    public int getInit() {
        return init;
    }

    public boolean estRecoltable(){return recoltable;}

    public int getRecolte() {
        return recolte;
    }

    public void pousser() {

        init += pasPousse;
        if (init >= recolte) {
            enPousse = false;
            recoltable = true;
        }
        if (init >= fanee) {
            estFanee = true;
            enPousse = false;
            recoltable = false;
        }
    }




    public int getX() {return x;}

    public int getY(){return y;}

    public int getTaille() {
        return taille;
    }


    public int getId() { return id;}

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean enPousse() { return enPousse;}

    public int getPrix() {
        if (this instanceof Rose) {
            return Rose.getPrix_fleur();
        }
        if (this instanceof Tournesol) {
            return Tournesol.getPrix_fleur();
        }
        if (this instanceof Muguet) {
            return Muguet.getPrix_fleur();
        }
        if (this instanceof FleurBleue) {
            return FleurBleue.getPrix_fleur();
        }

        return prix_fleur;
    }

    public boolean desherbementEnCours() {
    return desherbementEnCours;
    }
    public void setDesherbementEnCours(boolean b) {
        this.desherbementEnCours = b;
    }
}

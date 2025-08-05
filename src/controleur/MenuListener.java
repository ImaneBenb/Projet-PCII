package controleur;

import modele.*;
import vue.Fenetre;
import vue.PanneauControle;
import vue.VueCarte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {

    Carte carte;
    VueCarte vueCarte;
    Fenetre fenetre;
    PanneauControle pc;
    int x;
    int y;
    int prix;

    public MenuListener(Carte c,VueCarte vc, Fenetre f, PanneauControle pc, int x, int y){
        carte =c;
        vueCarte = vc;
        this.x = x;
        this.y = y;
        prix =0;
        this.fenetre = f;
        this.pc = pc;

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String nom = actionEvent.getActionCommand();
        switch (nom){
            case("Tulipe"):

                prix = Tulipe.getPrix_graine();
                if (carte.decrementeScore(prix)){
                    Tulipe t = new Tulipe(x,y);
                    carte.getListFleurs().add(t);
                    (new Pousse(vueCarte,  t , pc )).start();
                    fenetre.updateScore(true);

                }
                else{
                    fenetre.updateScore(false);


                }
                break;
            case ("Tournesol"):

                prix = Tournesol.getPrix_graine();

                if (carte.decrementeScore(prix)){
                    Tournesol t = new Tournesol(x,y);
                    carte.getListFleurs().add(t);
                    (new Pousse( vueCarte, t , pc )).start();
                    fenetre.updateScore(true);

                }
                else{
                    fenetre.updateScore(false);


                }
                break;
            case("Rose"):

                prix = Rose.getPrix_graine();
                if (carte.decrementeScore(prix)){
                    Rose r = new Rose(x,y);
                    carte.getListFleurs().add(r);
                    (new Pousse( vueCarte, r , pc )).start();
                    fenetre.updateScore(true);

                }
                else{
                    fenetre.updateScore(false);
                }

                break;
            case ("FleurBleue"):

                prix = FleurBleue.getPrix_graine();

                if (carte.decrementeScore(prix)){
                    FleurBleue fb = new FleurBleue(x,y);
                    carte.getListFleurs().add(fb);
                    (new Pousse( vueCarte, fb , pc )).start();
                    fenetre.updateScore(true);

                }
                else{
                    fenetre.updateScore(false);

                }

                break;
            case("Muguet"):

                prix = Muguet.getPrix_graine();
                if (carte.decrementeScore(prix)){
                    Muguet m = new Muguet(x,y);
                    carte.getListFleurs().add(m);
                    (new Pousse( vueCarte, m , pc )).start();
                    fenetre.updateScore(true);

                }
                else{
                fenetre.updateScore(false);

            }
                break;

        }
        pc.updatePanneau();

    }

    public void setCordonnee(int x,int y){
        this.x = x;
        this.y = y;
    }
}

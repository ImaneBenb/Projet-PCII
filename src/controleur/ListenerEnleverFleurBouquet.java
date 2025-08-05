package controleur;

import modele.Boutique;
import vue.PanneauBoutique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerEnleverFleurBouquet implements ActionListener {

    Boutique boutique;
    PanneauBoutique panneauBoutique;

    int numeroFleur;
    public ListenerEnleverFleurBouquet(Boutique b, PanneauBoutique p , int nb){
        boutique = b;
        panneauBoutique = p;
        numeroFleur = nb;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (numeroFleur) {
            case 0:
                boutique.enleverFleurBouquet(0);

                break;
            case 1:
                boutique.enleverFleurBouquet(1);
                break;
            case 2:
                boutique.enleverFleurBouquet(2);
                break;
        }
        panneauBoutique.updateBouquet();

    }
}

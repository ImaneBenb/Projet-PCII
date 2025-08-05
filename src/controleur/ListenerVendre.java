package controleur;

import modele.Boutique;
import vue.Fenetre;
import vue.PanneauBoutique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerVendre implements ActionListener {

    Boutique boutique;
    PanneauBoutique panneauBoutique;

    Fenetre fenetre;

    public ListenerVendre(Boutique b, PanneauBoutique pb , Fenetre f){
        boutique = b;
        panneauBoutique = pb;
        fenetre = f;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (boutique.vendre()) {
            panneauBoutique.updateBouquet();
            panneauBoutique.updateEngagerJardinier();
            fenetre.updateScore(true);
        }
    }
}

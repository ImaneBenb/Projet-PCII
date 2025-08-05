package controleur;

import modele.Boutique;
import vue.PanneauBoutique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAjouterRoseBouquet implements ActionListener {
    Boutique boutique;
    PanneauBoutique panneauBoutique;
    public ListenerAjouterRoseBouquet(Boutique b, PanneauBoutique pb){
        boutique = b;
        panneauBoutique = pb;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boutique.ajouterRoseAuBouquet();
        panneauBoutique.updateBouquet();

    }
}

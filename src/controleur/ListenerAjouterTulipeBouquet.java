package controleur;

import modele.Boutique;
import vue.PanneauBoutique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAjouterTulipeBouquet implements ActionListener {

    Boutique boutique;
    PanneauBoutique panneauBoutique;
    public ListenerAjouterTulipeBouquet(Boutique b, PanneauBoutique pb){
        boutique = b;
        panneauBoutique = pb;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boutique.ajouterTulipeAuBouquet();
        panneauBoutique.updateBouquet();
    }
}

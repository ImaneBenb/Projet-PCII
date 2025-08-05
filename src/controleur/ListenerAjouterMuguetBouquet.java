package controleur;

import modele.Boutique;
import vue.PanneauBoutique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAjouterMuguetBouquet implements ActionListener {
        Boutique boutique;
        PanneauBoutique panneauBoutique;
        public ListenerAjouterMuguetBouquet(Boutique b, PanneauBoutique pb){
            boutique = b;
            panneauBoutique = pb;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            boutique.ajouterMuguetAuBouquet();
            panneauBoutique.updateBouquet();

        }


}

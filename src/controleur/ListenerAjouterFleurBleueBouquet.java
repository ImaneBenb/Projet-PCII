package controleur;

import modele.Boutique;
import vue.PanneauBoutique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerAjouterFleurBleueBouquet implements ActionListener {
    Boutique boutique;
    PanneauBoutique panneauBoutique;
    public ListenerAjouterFleurBleueBouquet(Boutique b, PanneauBoutique pb){
        boutique = b;
        panneauBoutique = pb;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boutique.ajouterFleurBleueAuBouquet();
        panneauBoutique.updateBouquet();


    }
}

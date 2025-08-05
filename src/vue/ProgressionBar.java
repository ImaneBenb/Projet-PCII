package vue;

import modele.Fleur;

import javax.swing.*;
import java.awt.*;

public class ProgressionBar extends JPanel {

    private int min = 0;
    private JProgressBar progress;
    private Fleur f;

    public ProgressionBar(Fleur fleur) {
        f = fleur;
        progress = new JProgressBar(min, f.getFanee());
        progress.setBounds(40,40,165,30);
        progress.setValue(0);
        progress.setStringPainted(true);
        progress.setForeground(Color.YELLOW);
        this.add(progress);
        this.setSize(250,150);
    }

    public void setProgress(int value) {progress.setValue(value);}

    public void setFleur(Fleur fleur) {
        f = fleur;
    }


    public void updateColor() {
        if (f.getInit() >= f.getRecolte() && f.getInit() < f.getFanee()) {
            progress.setForeground(Color.GREEN);
        }
        else if (f.getInit() >= 90) {
            progress.setForeground(Color.RED);
        }
    }
}

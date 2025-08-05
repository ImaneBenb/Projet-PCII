package vue;

public class Redessine extends Thread {

    Fenetre fenetre;

    private static final int DELAI_DEPLACEMENT = 50;

    public Redessine(Fenetre f){
        fenetre =f;

    }
    @Override
    public void run() {
        while (true) {
            try {

                fenetre.updateTime();
                fenetre.updateColor();
                fenetre.repaint();
                fenetre.revalidate();





                Thread.sleep(DELAI_DEPLACEMENT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

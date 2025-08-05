package modele;
import java.util.Timer;
import java.util.TimerTask;

public class CountDownTimer {
    private Timer timer;
    private int courentTime = 0; // temps actuel
    private final int MAX_TIME = 120; // 2 minutes en secondes

    //le constrcuteur lance le timer du jeu
    public CountDownTimer(){
        this.startTimer();
    }

    public int getCourentTime(){
        return courentTime;
    }

    public int getMaxTime(){
        return MAX_TIME;
    }

    public int getTempsRestant(){
        return MAX_TIME - courentTime;
    }

    //lance le timer du jeu
    public void startTimer(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                courentTime++;
                if (courentTime > MAX_TIME) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
}

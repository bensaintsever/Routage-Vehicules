package algo.bss;



/**
 * Created by benjamin.saint-sever on 30/11/2016.
 */
public abstract class TimerHeuristique extends Thread {

    protected abstract void heuristique();
    protected abstract boolean continuer();
    protected abstract void initContinue(boolean value);

    public final void run(){
        while(continuer()){
            try {
                sleep(0);//bidouillage
                heuristique();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

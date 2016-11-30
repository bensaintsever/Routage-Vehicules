package algo.bss;

/**
 * Created by benjamin.saint-sever on 30/11/2016.
 */
public class HeuristiqueSansContraintes extends TimerHeuristique{

    private boolean val;

    public void initContinue(boolean value){
        this.val = value;
    }
    @Override
    protected void heuristique() {
        System.out.println("Je suis l'heuristique sans contraintes");
    }

    @Override
    protected boolean continuer() {
        return val;
    }



    public void testsc(){

    }


}

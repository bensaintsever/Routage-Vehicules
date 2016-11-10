package algo.bss;

/**
 * Created by benjamin.saint-sever on 10/11/2016.
 */
public class Camion {
    private float positionX;



    private float positionY;

    //Optionnel
    private Integer capacite;


    public Camion(float positionX, float positionY, Integer capacite) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.capacite = capacite;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public Integer getCapacite() {
        return capacite;
    }
}

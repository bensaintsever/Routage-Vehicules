package algo.bss;

import java.util.ArrayList;

/**
 * Created by benjamin.saint-sever on 10/11/2016.
 */
public class Camion {
    private float positionX;
    private float positionY;

    //Parcours des clients à visiter.
    private ArrayList<Client> listeClient;

    //Optionnel

    public ArrayList<Client> getListeClient() {
        return listeClient;
    }

    private Integer capacite;


    public Camion(float positionX, float positionY, Integer capacite,
                  ArrayList<Client> list) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.capacite = capacite;
        this.listeClient = list;
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

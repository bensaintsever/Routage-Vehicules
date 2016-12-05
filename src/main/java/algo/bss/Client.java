package algo.bss;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by benjamin.saint-sever on 10/11/2016.
 */
public class Client {

    private Integer idClient;
    private float dureeMin;
    private float dureeMax;
    private float quantite;
    private float duree_arret_passage;

    private double positionX;
    private double positionY;

    public void setProcheVoisins(Vector<Client> procheVoisins) {
        this.procheVoisins = procheVoisins;
    }

    //private ArrayList<Client> procheVoisins;
    private Vector<Client> procheVoisins;

    public Client(Integer idClient, double positionX, double positionY, float
            quantite, float dureeMin, float dureeMax, float duree_arret_passage) {
        this.idClient = idClient;
        this.dureeMin = dureeMin;
        this.dureeMax = dureeMax;
        this.quantite = quantite;
        this.positionX = positionX;
        this.positionY = positionY;
        this.duree_arret_passage = duree_arret_passage;
    }


    public Integer getIdClient() {
        return idClient;
    }


    protected Client clone() {
        return new Client(idClient,positionX,positionY,quantite,
                dureeMin,dureeMax,duree_arret_passage);
    }

    public float getDureeMin() {
        return dureeMin;
    }

    public float getDureeMax() {
        return dureeMax;
    }

    public float getQuantite() {
        return quantite;
    }


    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public float getDuree_arret_passage() {
        return duree_arret_passage;
    }


    public void afficher_Client(){
        System.out.println(this.idClient + " " +this.positionX + " " +this
                .positionY + " " +
                this
                .quantite + " " + this.dureeMin + " " +this.dureeMax + " " + this
                .duree_arret_passage);
    }
}

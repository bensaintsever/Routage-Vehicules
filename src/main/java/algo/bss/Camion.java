package algo.bss;

import java.util.ArrayList;

/**
 * Created by benjamin.saint-sever on 10/11/2016.
 */
public class Camion {
    private float positionX;
    private float positionY;

    private Integer capacite;

    //Parcours des clients à visiter.
    private ArrayList<Client> listeClient;




    public void setListeClient(ArrayList<Client> listeClient) {
        this.listeClient = listeClient;
    }


    protected Camion clone() {
        Camion c = new Camion(positionX,positionY,capacite,listeClient);


        ArrayList<Client> cloneClient = new ArrayList<Client>(this
                .listeClient.size());
        for(Client client : this.listeClient)
            cloneClient.add(client.clone());

        return c;
    }

    public ArrayList<Client> getListeClient() {
        return listeClient;
    }

    public Camion(float positionX, float positionY, Integer capacite,
                  ArrayList<Client> list) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.capacite = capacite;

        this.listeClient  = new ArrayList<Client>(list.size());
        for(Client client : list)
            this.listeClient.add(client.clone());
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

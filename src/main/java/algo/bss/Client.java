package algo.bss;

/**
 * Created by benjamin.saint-sever on 10/11/2016.
 */
public class Client {

    private Integer idClient;
    private float dureeMin;
    private float dureeMax;
    private Integer quantite;
    private float poids;

    private float positionX;
    private float positionY;

    public Client(Integer idClient, float dureeMin, float dureeMax,
                  Integer quantite, float poids, float positionX,
                  float positionY) {
        this.idClient = idClient;
        this.dureeMin = dureeMin;
        this.dureeMax = dureeMax;
        this.quantite = quantite;
        this.poids = poids;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public float getDureeMin() {
        return dureeMin;
    }

    public float getDureeMax() {
        return dureeMax;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public float getPoids() {
        return poids;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }
}

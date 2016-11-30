package algo.bss;

/**
 * Created by benjamin.saint-sever on 10/11/2016.
 */
public class Client {

    private Integer idClient;
    private float dureeMin;
    private float dureeMax;
    private float quantite;
    private float duree_arret_passage;

    private float positionX;
    private float positionY;

    public Client(Integer idClient, float positionX, float positionY, float
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

    public float getDureeMin() {
        return dureeMin;
    }

    public float getDureeMax() {
        return dureeMax;
    }

    public float getQuantite() {
        return quantite;
    }


    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
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

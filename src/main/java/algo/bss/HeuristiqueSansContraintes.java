package algo.bss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;


/**
 * Created by benjamin.saint-sever on 30/11/2016.
 */
public class HeuristiqueSansContraintes extends TimerHeuristique {

    private boolean val;
    private ArrayList<Client> listClient;
    private ArrayList<Camion> listCamion;

    public HeuristiqueSansContraintes(ArrayList<Client> listClient) {
        this.listClient = listClient;
    }

    public void initContinue(boolean value) {
        this.val = value;
    }

    @Override
    protected void heuristique() {
        testsc();
        this.val = false;
        //System.out.println("Je suis l'heuristique sans contraintes");
    }

    @Override
    protected boolean continuer() {
        return val;
    }

    private ArrayList<Client> fctClientRand(int nbClient) {
        System.out.println("Appel a fctClientRand, nbClient : " + nbClient);


        ArrayList<Client> nouvelleListClient = new ArrayList<Client>();

        int tailleList = listClient.size();

        for (int i = 0; i < nbClient; ++i) {
            int nbAleatoire;


            nbAleatoire = new Random().nextInt(tailleList);
            //System.out.println("nbAleatoire : " + nbAleatoire);


            nouvelleListClient.add(
                    listClient.remove(nbAleatoire)
            );
            tailleList--;
            //System.out.println("borne " + tailleList);
            //System.out.println("i " + i + " et nbClient : "+ listClient.size
            //   ());

        }


        return nouvelleListClient;

    }

    private double distanceEntre2Points(double x1, double x2, double y1, double
            y2){
        double _x = x1-x2;
        double _y = y1-y2;

        double xSqr = Math.pow(_x,2);
        double ySqr = Math.pow(_y,2);

        return Math.sqrt(xSqr + ySqr);
    }

    public void testsc() {
        //A mettre dans heuristique

        //INITIALISATION DES LISTES DE CLIENTS POUR CHAQUE CAMION

        int nbCamion = 2;

        int nbClient = listClient.size();

        int nbClientParCamion = (nbClient / nbCamion);
        int nbAjoutMod = nbClient % nbCamion;

        listCamion = new ArrayList<Camion>();
        //On commence par ajouter les surplus de clients
        for (int i = 0; i < nbAjoutMod; ++i) {
            listCamion.add(
                    new Camion(0, 0, 0,
                            fctClientRand(nbClientParCamion + 1)
                    )
            );
        }

        //ET on ajoute tous les autres clients
        for (int camionX = nbAjoutMod; camionX < nbCamion; ++camionX) {
            listCamion.add(
                    new Camion(0, 0, 0,
                            fctClientRand(nbClientParCamion)
                    )
            );
        }


        /* AFFICHAGE DE TEST DES LISTES CLIENT DES CAMIONS
        System.out.println("Affichage de " + listCamion.get(0).getListeClient
                ().size() + "clients " +
                "de " +
                "camion 0");
        ArrayList<Client> l = listCamion.get(0).getListeClient();
        Iterator it = l.iterator();

        while (it.hasNext()) {

            Client c = (Client) it.next();
            c.afficher_Client();


        }


        System.out.println("Affichage de "+ listCamion.get(1).getListeClient
                ().size() +"clients de camion 1");
        ArrayList<Client> l2  = listCamion.get(1).getListeClient();
        Iterator it2 = l2.iterator();
        while (it2.hasNext()) {
            Client c2 = (Client) it2.next();
            c2.afficher_Client();

        }
        */


        int kVoisins = 3;


        //ALGO
        //On part d'un camion

        //REF
        //ON COMPARE LES DISTANCES DE TOUS LES PTS DU CAMION
        //ON GARDE LES 3 PLUS PROCHES
        //ON AVANCE SUR LE CLIENTS SUIVANT
        //A PARTIR DE SE CLIENT ON GO TO REF JUSQU'A NE PLUS AVOIR DE CLIENT


        Camion x = listCamion.get(0);

        ArrayList<Client> listC = x.getListeClient();
        Vector<Client> VoisinsProchesCamion = new Vector<Client>(kVoisins);

        //PARCOUR DE TOUS LES CLIENTS
        Iterator it = listC.iterator();
        int i = 0;
        while(it.hasNext()){
            Client c = (Client) it.next();

            //Init de k voisins
            while( i < kVoisins ){
                VoisinsProchesCamion.add(c);
                i++;
                c = (Client) it.next();
            }

            double distanceEuclidienne = distanceEntre2Points(x.getPositionX(),x
                    .getPositionY(),c
                    .getPositionX(),c.getPositionY());

            //compareVoisins(VoisinsProchesCamion, distanceEuclidienne);


        }


        //Camion 0
       /* ArrayList<Client> listC = listCamion.get(0).getListeClient();
        Iterator it = listC.iterator();
        while(it.hasNext()){

            Client c = (Client) it.next();

            Iterator it2 = listC.iterator();
            while(it.hasNext()){
                Client c2 = (Client) it.next();
                double distanceRef = distanceEntre2Points(c.getPositionX(),c
                        .getPositionY(),
                        c2.getPositionX(),c2.getPositionY());
                if ()
            }
            //c.setProcheVoisins();


        }*/



        for(int i = 0 ; i < 3; ++i){

        }

    }


}

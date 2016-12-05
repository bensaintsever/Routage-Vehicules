package algo.bss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;


/**
 * Created by benjamin.saint-sever on 30/11/2016.
 */
public class heuristiqueSansContraintes extends TimerHeuristique {

    private boolean val;
    private ArrayList<Client> listClient;
    private ArrayList<Camion> listCamion;

    /**
     * Constructeur d'une heuristique sans contraintes.
     *
     * @param listClient initialise une liste client.
     */
    public heuristiqueSansContraintes(ArrayList<Client> listClient) {
        this.listClient = listClient;
    }

    /**
     * Méthode permettant de modifer/initialiser une variable déterminant
     * l'arret et la prologation d'un thread.
     *
     * @param value valeur de la continuité du thread.
     */
    public void initContinue(boolean value) {
        this.val = value;
    }

    /**
     * Méthode permettant de connaitre la valeur de continuité du thread.
     *
     * @return vrai si le thread se prolonge et faux si il doit se terminer.
     */
    @Override
    protected boolean continuer() {
        return val;
    }

    /**
     * Appel de l'heuristique implementé par cette classe.
     */
    @Override
    protected void heuristique() {
        testsc();
        this.val = false;
        //System.out.println("Je suis l'heuristique sans contraintes");
    }


    /**
     * Methode permettant de générer aleatoirement une sequence de client
     * basé sur une liste passé en paramètre.
     *
     * @param listeClient liste de client à sequencer.
     * @param nbClient    nombre de client à retenir dans la liste produite,
     *                    parmis les n en entrée.
     * @return une liste de client sequencé aleatoirement et contenant
     * nbClient (un certain nombre de client).
     */
    private ArrayList<Client> sequencageAleatoireListeClient(ArrayList<Client> listeClient, int
            nbClient) {
        System.out.println("Appel a fctClientRand, nbClient : " + nbClient);


        ArrayList<Client> nouvelleListeClient = new ArrayList<Client>();

        int tailleList = listeClient.size();

        for (int i = 0; i < nbClient; ++i) {
            int nbAleatoire;


            nbAleatoire = new Random().nextInt(tailleList);
            //System.out.println("nbAleatoire : " + nbAleatoire);


            nouvelleListeClient.add(
                    listeClient.remove(nbAleatoire)
            );
            tailleList--;
            //System.out.println("borne " + tailleList);
            //System.out.println("i " + i + " et nbClient : "+ listClient.size
            //   ());

        }


        return nouvelleListeClient;

    }

    /**
     * Méthode permettant le calcul de la distance euclidienne entre deux points
     * (2 dimensions).
     * @param x1 abscisse point 1
     * @param x2 abscisse point 2
     * @param y1 ordonnee point 1
     * @param y2 ordonnee point 2
     * @return distance euclidienne entre deux points.
     */
    private double distanceEntre2Points(double x1, double x2, double y1, double
            y2) {
        double _x = x1 - x2;
        double _y = y1 - y2;

        double xSqr = Math.pow(_x, 2);
        double ySqr = Math.pow(_y, 2);

        return Math.sqrt(xSqr + ySqr);
    }


    /**
     * Genere de nouveau chemin aleatoire, pouvant etre désigner comme solution.
     */
    private void genererSolutionAleatoireToutCamion(){
        Iterator itCamion = listCamion.iterator();
        int indiceCamion = 0;
        while (itCamion.hasNext()) {
            Camion camionRef = (Camion) itCamion.next();

            //GENERATION D'UNE SOLUTION ALEATOIRE ( ETAPE 1)

            Camion camionTmp = listCamion.get(indiceCamion);
            //On modifie la liste client d'un camion (modifier
            // l'ordonnencement de cette liste)
            camionTmp.setListeClient(
                    sequencageAleatoireListeClient(camionRef
                                    .getListeClient(),
                            camionRef.getListeClient().size()));


            //On re-insere la ref de ce "nouveau camion" pour modifer
            // l'ordonnement de l'ancien
            listCamion.set(indiceCamion,camionTmp);


            indiceCamion++;
        }
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
                            sequencageAleatoireListeClient(listClient, nbClientParCamion + 1)
                    )
            );
        }

        //ET on ajoute tous les autres clients
        for (int camionX = nbAjoutMod; camionX < nbCamion; ++camionX) {
            listCamion.add(
                    new Camion(0, 0, 0,
                            sequencageAleatoireListeClient(listClient, nbClientParCamion)
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


        //PAS BESOIN ICI CAR ON A DEJA INITIALEMENT GENERER DES
        // CHEMINS ALEATOIRE QUE L'ON PEUT DESIGNER DE SOLUTION PROVISOIRE

        // POUR CHAQUE CAMION

        //S* = S a faire pour chaque camion ?
        ArrayList<Camion> _solutionReferente = new ArrayList<Camion>(this
                .listCamion.size());
        for(Camion item : listCamion) _solutionReferente.add(item.clone());





        //ON COMPARE CHAQUE CIBLE AVEC K CLIENTS ...
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
        while (it.hasNext()) {
            Client c = (Client) it.next();

            //Init de k voisins (3 voisins proches)
            while (i < kVoisins) {
                VoisinsProchesCamion.add(c);
                i++;
                c = (Client) it.next();
            }

            double distanceEuclidienne = distanceEntre2Points(x.getPositionX(), x
                    .getPositionY(), c
                    .getPositionX(), c.getPositionY());

            //compareVoisins(VoisinsProchesCamion, distanceEuclidienne);


        }


        // SOLUTION ALEATOIRE

        // FONCTIONSOLUTIONALEATOIRE(camion)
        //Camion 0
       /* ArrayList<Client> listC = listCamion.get(0).getListeClient();
        Iterator it = listC.iterator();
        while(it.hasNext()){

            Client c = (Client) it.next();

            Iterator it2 = listC.iterator();
            while(it.hasNext()){
                Client c2;
                do{
                    c2 = (Client) it.next();
                }while(c2 == c); //VERIFIER

                double distanceRef = distanceEntre2Points(c.getPositionX(),c
                        .getPositionY(),
                        c2.getPositionX(),c2.getPositionY());
                if ()
            }
            //c.setProcheVoisins();





        }
        /*On prend une solution s (solution aléatoire)
        S* <- S
        répéter // Tant que S* n’est pas un optimum local, répéter
        S’ <- meilleur voisin(S)
        Si cout(S’) < cout(S)
        S <- S’
        Sinon
        //Seulement ce n’est pas suffisant, le cherche le min global
        Si cout(S) < cout(S*)
        S* <— S
        S <— solution-aléatoire
       */




       /* for (int i = 0; i < 3; ++i) {

        }*/

    }


}

package algo.bss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class App {


    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Nombre d'arguments incomplet, usage : " +
                    "./nom_Programme dureeMaximaleDeTraitement " +
                    "nomDuFichierCible");
        } else {
            String time = args[0];
            String pathname = args[1];


            int capacite = 0;
            int nbClient = 0;

            ArrayList<Client> listeClient = new ArrayList<Client>();


            // ANALYSE FICHIER

            try {
                File f = new File(pathname);
                Scanner sc = new Scanner(f);

                boolean fichierValide = true;


                if (sc.next().compareTo("Cap") == 0) {
                    capacite = sc.nextInt();
                } else
                    fichierValide = false;

                // On saute les entetes textes
                sc.next();
                sc.next();
                sc.next();
                sc.next();
                sc.next();
                sc.next();
                sc.next();


                while (fichierValide && sc.hasNext()) {


                    //Parsing des données clients
                    Client clientActuel = new Client(sc.nextInt(),
                            Float.parseFloat(sc.next()),
                            Float.parseFloat(sc.next()),
                            Float.parseFloat(sc.next()),
                            Float.parseFloat(sc.next()),
                            Float.parseFloat(sc.next()),
                            Float.parseFloat(sc.next()));

                    // On stocke les clients
                    listeClient.add(clientActuel);

                }


            } catch (FileNotFoundException e) {
                System.out.println("Le fichier n'a pas été trouvé");
            }


            // AFFICHAGE CLIENTS
            Iterator it = listeClient.iterator();
            while (it.hasNext()) {
                Client c = (Client) it.next();
                c.afficher_Client();

            }


            TimerHeuristique t = new HeuristiqueSansContraintes();
            long start = System.currentTimeMillis();
            try {
                t.initContinue(true);
                t.start();

                t.join(Long.parseLong(time) * 1000);
                t.initContinue(false);

                System.out.println("Run time thread : " + (System
                        .currentTimeMillis() - start));


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

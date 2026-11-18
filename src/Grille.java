package src;

import java.util.ArrayList;
import java.util.List;

public class Grille {

   private Cellule[][] grille;
   private final List<Convoyeur> convoyeurs;

   public Grille(Cellule[][] grille) {
       this.grille = grille;
       convoyeurs = new ArrayList<>();
   }

    public Grille() {
        grille = new Cellule[10][10];
        convoyeurs = new ArrayList<>();
    }

    public Grille(int largeur, int hauteur) {
       grille = new Cellule[hauteur][largeur];
       convoyeurs = new ArrayList<>();
        for (int y = 0; y < hauteur; y++) {
           for (int x = 0; x < largeur; x++) {
               grille[y][x] = new Cellule(x, y);
            }
        }
    }

    public void ajouter(Tapis tapis) {
       Cellule emplacement = tapis.emplacement();
       if (emplacement != null && !convoyeurs.contains(tapis)) {
           convoyeurs.add(tapis);
        }

       if (emplacement == null) {
           return;
       }
        int y = emplacement.getY();
        int x = emplacement.getX();
        if (y >= 0 && y < grille.length
            && x >= 0 && x < grille[y].length) {
            grille[y][x] = emplacement;
       }
    }

    public void update() {
       for (Convoyeur convoyeur : convoyeurs) {
            convoyeur.ajouter_forme();

            Forme forme = convoyeur.getForme();
            if (forme == null) {
               continue;
            }

            Machine machineDestination = convoyeur.destination();
           if (machineDestination != null
                   && machineDestination.est_disponible()) {
               machineDestination.stocker_forme(forme);
               machineDestination.ajouter_forme();
                 convoyeur.extraire_forme();
            }
        }
    }

    public List<Forme> getFormesPresentes() {
       List<Forme> formes = new ArrayList<>();
       for (Convoyeur convoyeur : convoyeurs) {
           if (convoyeur.getForme() != null) {
               formes.add(convoyeur.getForme());
            }
           if (convoyeur.getStockage() != null) {
               formes.add(convoyeur.getStockage());
           }
        }
        return formes;
    }
}
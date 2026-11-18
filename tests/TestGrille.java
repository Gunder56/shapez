package tests;

import java.util.List;

import src.Cardinal;
import src.Cellule;
import src.Forme;
import src.Grille;
import src.Tapis;

public class TestGrille {
    public static void main(String[] args) {
        Grille grille = new Grille(3, 3);
        Tapis tapis1 = new Tapis(new Cellule(0, 0), Cardinal.OUEST, Cardinal.EST);
        Tapis tapis2 = new Tapis(new Cellule(1, 0), Cardinal.OUEST, Cardinal.EST);

        grille.ajouter(tapis1);
        grille.ajouter(tapis2);

        Forme forme = new Forme(1);
        tapis1.stocker_forme(forme);
        tapis1.ajouter_forme();

        List<Forme> formesAvant = grille.getFormesPresentes();
        grille.update();
        List<Forme> formesApres = grille.getFormesPresentes();

        if (formesAvant.size() != formesApres.size()
                || formesAvant.size() != 1
                || !formesAvant.containsAll(formesApres)
                || !formesApres.containsAll(formesAvant)) {
            throw new AssertionError("Les formes n'ont pas été conservées");
        }

        System.out.println("Grille testée avec succès.");
    }
}

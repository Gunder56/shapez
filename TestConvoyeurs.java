
package src.tests;

import java.util.ArrayList;
import java.util.List;

import src.Tapis;

public class TestConvoyeurs {

    public static void main(String[] args) {
        List<String> echecs = new ArrayList<>();

        executer("test 7", echecs, TestConvoyeurs::test7);
        executer("test 7bis", echecs, TestConvoyeurs::test7bis);
        executer("test 8", echecs, TestConvoyeurs::test8);

        if (!echecs.isEmpty()) {
            throw new AssertionError("Scénarios en échec : " + String.join(", ", echecs));
        }

        System.out.println("Les scénarios 7, 7bis et 8 ont réussi.");
    }

    private static void test7() {
        Cellule cellule1 = new Cellule(0, 0);
        Cellule cellule2 = new Cellule(0, 1);
        Cellule cellule3 = new Cellule(1, 0);
        Cellule cellule4 = new Cellule(1, 1);

        Tapis c1 = new Tapis(cellule1, Cardinal.NORD, Cardinal.SUD);
        Tapis c2 = new Tapis(cellule2, Cardinal.EST, Cardinal.SUD);
        Tapis c3 = new Tapis(cellule3, Cardinal.EST, Cardinal.OUEST);
        Tapis c4 = new Tapis(cellule4, Cardinal.EST, Cardinal.OUEST);

        verifierDestination(c1, c3, "C1.destination doit être C3");
        verifierDestination(c2, null, "C2.destination doit être null (direction incompatible)");
        verifierDestination(c3, c4, "C3.destination doit être C4");
        verifierDestination(c4, null, "C4.destination doit être null");
    }

    private static void test7bis() {
        Cellule cellule1 = new Cellule(0, 0);
        Cellule cellule2 = new Cellule(0, 1);
        Cellule cellule3 = new Cellule(1, 0);
        Cellule cellule4 = new Cellule(1, 1);

        Tapis c1 = new Tapis(cellule1, Cardinal.NORD, Cardinal.SUD);
        Tapis c2 = new Tapis(cellule2, Cardinal.EST, Cardinal.SUD);
        new Tapis(cellule3, Cardinal.EST, Cardinal.OUEST);
        new Tapis(cellule4, Cardinal.EST, Cardinal.OUEST);

        c1.getSorties()[0] = new CelluleOriente(cellule2, Cardinal.EST);
        verifierDestination(c1, c2, "Après la sortie est de C1, C1.destination doit être C2");
    }

    private static void test8() {
        Tapis c = new Tapis(new Cellule(0, 0), Cardinal.NORD, Cardinal.SUD);
        Forme forme = new Forme(0);
        c.getSorties()[0] = null;

        c.stocker_forme(forme);
        c.deplacer_forme();

        if (c.getForme() != forme) {
            throw new AssertionError("C doit conserver une forme quand sa destination est null");
        }
    }


    private static void test9() {
        Cellule cellule1 = new Cellule(0, 0);
        Cellule cellule2 = new Cellule(1, 0);
        Cellule cellule3 = new Cellule(2, 0);
        Tapis c1 = new Tapis(cellule1, Cardinal.EST, Cardinal.OUEST);
        Tapis c2 = new Tapis(cellule2, Cardinal.EST, Cardinal.SUD);
        Tapis c3 = new Tapis(cellule3, Cardinal.OUEST, Cardinal.EST);

        verifierDestination(c1, c2, "C1.destination doit être C2");
        verifierDestination(c3, null, "C3.destination doit être null");

    }
    private static void test9Bis() {
        Grille grille = new Grille();
        Cellule cellule1 = new Cellule(0, 0);
        Cellule cellule2 = new Cellule(1, 0);
        Cellule cellule3 = new Cellule(2, 0);
        Tapis c1 = new Tapis(cellule1, Cardinal.EST, Cardinal.OUEST);
        Tapis c2 = new Tapis(cellule2, Cardinal.EST, Cardinal.SUD);
        Tapis c3 = new Tapis(cellule3, Cardinal.OUEST, Cardinal.EST);

        Forme f1 = new Forme(1);
        c1.stocker_forme(f1);
        Forme f3 = new Forme(3);
        c3.stocker_forme(f3);
    
        grille.update();

        if (c2.getForme() != f1) {
            throw new AssertionError("C2 doit avoir une forme après l'update");
        }
        if (c3.getForme() != f3) {
            throw new AssertionError("C3 doit avoir une forme après l'update");
        }


    }

    private static void verifierDestination(Tapis convoyeur, Machine destinationAttendue, String message) {
        if (convoyeur.destination() != destinationAttendue) {
            throw new AssertionError(message);
        }
    }

    private static void executer(String nom, List<String> echecs, Runnable scenario) {
        try {
            scenario.run();
            System.out.println(nom + " réussi.");
        } catch (AssertionError erreur) {
            echecs.add(nom + " : " + erreur.getMessage());
            System.err.println(nom + " échoué : " + erreur.getMessage());
        }
    }
}


package src.tests;

import java.util.ArrayList;
import java.util.List;
import src.Cardinal;
import src.Cellule;
import src.CelluleOriente;
import src.Forme;
import src.Grille;
import src.Machine;
import src.Tapis;


public class TestFirstPart {

    public static void main(String[] args) {
        List<String> echecs = new ArrayList<>();

        executer("test 1", echecs, TestFirstPart::test1);
        executer("test 1bis", echecs, TestFirstPart::test1Bis);
        executer("test 2", echecs, TestFirstPart::test2);
        executer("test 2bis", echecs, TestFirstPart::test2Bis);
        executer("test 3", echecs, TestFirstPart::test3);
        executer("test 4", echecs, TestFirstPart::test4);
        executer("test 5", echecs, TestFirstPart::test5);
        executer("test 6", echecs, TestFirstPart::test6);
        executer("test 7", echecs, TestFirstPart::test7);
        executer("test 7bis", echecs, TestFirstPart::test7bis);
        executer("test 8", echecs, TestFirstPart::test8);
        executer("test 9", echecs, TestFirstPart::test9);
        executer("test 9bis", echecs, TestFirstPart::test9Bis);
        executer("test 10", echecs, TestFirstPart::test10);

        if (!echecs.isEmpty()) {
            throw new AssertionError("Scénarios en échec : " + String.join(", ", echecs));
        }

        System.out.println("Les scénarios 7, 7bis et 8 ont réussi.");
    }

    private static void test1() {
        Tapis convoyeur = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.OUEST);
        Forme forme = new Forme(1);

        convoyeur.stocker_forme(forme);
        convoyeur.ajouter_forme();

        if (convoyeur.getForme() != forme || convoyeur.getStockage() != null) {
            throw new AssertionError("ajouter_forme() doit charger la forme et vider le stockage");
        }
    }

    private static void test1Bis() {
        Tapis convoyeur = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.OUEST);
        Forme forme = new Forme(1);

        convoyeur.stocker_forme(forme);

        if (convoyeur.getStockage() != forme) {
            throw new AssertionError("stocker_forme() doit remplir l'attribut stockage");
        }
    }

    private static void test2() {
        Tapis convoyeur = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.OUEST);
        Forme forme1 = new Forme(1);

        convoyeur.stocker_forme(forme1);
        convoyeur.stocker_forme(new Forme(2));

        if (convoyeur.getStockage() != forme1) {
            throw new AssertionError("Le stockage occupé ne doit pas être écrasé");
        }
    }

    private static void test2Bis() {
        Tapis convoyeur = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.OUEST);
        Forme forme1 = new Forme(1);
        Forme forme2 = new Forme(2);

        convoyeur.stocker_forme(forme1);
        convoyeur.ajouter_forme();
        convoyeur.stocker_forme(forme2);
        convoyeur.ajouter_forme();

        if (convoyeur.getForme() != forme1 || convoyeur.getStockage() != forme2) {
            throw new AssertionError("ajouter_forme() ne doit pas écraser la forme présente");
        }
    }

    private static void test3() {
        Tapis source = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.EST);
        Tapis destination = new Tapis(new Cellule(1, 0), Cardinal.OUEST, Cardinal.EST);
        source.getSorties()[0] = new CelluleOriente(destination.emplacement(), Cardinal.EST);
        Forme forme = new Forme(1);

        source.stocker_forme(forme);
        source.ajouter_forme();
        source.deplacer_forme();

        if (source.getForme() != null || destination.getForme() != forme) {
            throw new AssertionError("La forme doit passer du convoyeur source à la destination");
        }
    }

    private static void test4() {
        Tapis source = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.EST);
        Tapis destination = new Tapis(new Cellule(1, 0), Cardinal.OUEST, Cardinal.EST);
        source.getSorties()[0] = new CelluleOriente(destination.emplacement(), Cardinal.EST);
        Forme forme1 = new Forme(1);
        Forme forme2 = new Forme(2);

        source.stocker_forme(forme1);
        source.ajouter_forme();
        destination.stocker_forme(forme2);
        destination.ajouter_forme();
        source.deplacer_forme();

        if (source.getForme() != forme1 || destination.getForme() != forme2) {
            throw new AssertionError("Une destination occupée ne doit pas être écrasée");
        }
    }

    private static void test5() {
        test4();

        Tapis source = new Tapis(new Cellule(2, 0), Cardinal.EST, Cardinal.EST);
        Tapis destination = new Tapis(new Cellule(3, 0), Cardinal.OUEST, Cardinal.EST);
        source.getSorties()[0] = new CelluleOriente(destination.emplacement(), Cardinal.EST);
        Forme forme1 = new Forme(1);
        Forme forme2 = new Forme(2);

        source.stocker_forme(forme1);
        source.ajouter_forme();
        destination.stocker_forme(forme2);
        destination.ajouter_forme();
        destination.extraire_forme();
        source.deplacer_forme();

        if (source.getForme() != null || destination.getForme() != forme1) {
            throw new AssertionError("Après libération, la forme doit atteindre la destination");
        }
    }

    private static void test6() {
        Tapis source = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.EST);
        source.getSorties()[0] = null;
        Forme forme = new Forme(1);

        source.stocker_forme(forme);
        source.ajouter_forme();
        source.deplacer_forme();

        if (source.getForme() != forme) {
            throw new AssertionError("Sans destination, la forme doit rester sur le convoyeur");
        }
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
        c1.getSorties()[0] = new CelluleOriente(c3.emplacement(), Cardinal.SUD);
        c3.getSorties()[0] = new CelluleOriente(c4.emplacement(), Cardinal.EST);

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
        c1.getSorties()[0] = new CelluleOriente(c2.emplacement(), Cardinal.EST);

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
        c1.getSorties()[0] = new CelluleOriente(c2.emplacement(), Cardinal.EST);
        grille.ajouter(c1);
        grille.ajouter(c2);
        grille.ajouter(c3);

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

    private static void test10() {
        Grille grille = new Grille(3, 3);
        Tapis tapis1 = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.EST);
        Tapis tapis2 = new Tapis(new Cellule(1, 0), Cardinal.OUEST, Cardinal.EST);
        tapis1.getSorties()[0] = new CelluleOriente(tapis2.emplacement(), Cardinal.EST);

        grille.ajouter(tapis1);
        grille.ajouter(tapis2);

        Forme forme = new Forme(1);
        tapis1.stocker_forme(forme);
        tapis1.ajouter_forme();

        List<Forme> avant = grille.getFormesPresentes();
        for (int i = 0; i < 10; i++) {
            grille.update();
        }
        List<Forme> apres = grille.getFormesPresentes();

        if (avant.size() != 1
                || apres.size() != avant.size()
                || !avant.containsAll(apres)
                || !apres.containsAll(avant)) {
            throw new AssertionError("update() doit conserver la liste des formes");
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
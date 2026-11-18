package src;

public class main {
    public static void main(String[] args) {
        testerCellule();
        testerTapis();
        testerGrille();

        System.out.println("Tous les tests du programme principal ont réussi.");
    }

    private static void testerCellule() {
        Cellule cellule = new Cellule(2, 3);
        verifier(cellule.getX() == 2, "Coordonnée X incorrecte");
        verifier(cellule.getY() == 3, "Coordonnée Y incorrecte");
        verifier(cellule.est_libre(), "La cellule devrait être libre");

        Tapis tapis = new Tapis(cellule, Cardinal.EST, Cardinal.OUEST);
        verifier(!tapis.emplacement().est_libre(), "Le tapis doit occuper la cellule");
        verifier(cellule.est_libre() == false, "Le tapis doit occuper la cellule");
    }

    private static void testerTapis() {
        Tapis tapis = new Tapis(new Cellule(1, 1), Cardinal.NORD, Cardinal.SUD);

        verifier(tapis.getEntrees().length == 1, "Le tapis doit avoir une entrée");
        verifier(tapis.getSorties().length == 1, "Le tapis doit avoir une sortie");
        verifier(tapis.est_disponible(), "Le tapis vide doit être disponible");

        Forme forme = new Forme(42);
        tapis.stocker_forme(forme);
        verifier(tapis.getStockage() == forme, "Le stockage du tapis est incorrect");

        tapis.ajouter_forme();
        verifier(tapis.getForme() == forme, "La forme n'a pas été chargée");
        verifier(!tapis.est_disponible(), "Le tapis devrait être occupé après chargement");
    }

    private static void testerGrille() {
        Grille grille = new Grille(3, 3);
        Tapis tapis1 = new Tapis(new Cellule(0, 0), Cardinal.EST, Cardinal.EST);
        Tapis tapis2 = new Tapis(new Cellule(1, 0), Cardinal.OUEST, Cardinal.OUEST);

        grille.ajouter(tapis1);
        grille.ajouter(tapis2);

        Forme forme = new Forme(7);
        tapis1.stocker_forme(forme);
        tapis1.ajouter_forme();

        int nombreAvant = grille.getFormesPresentes().size();
        grille.update();
        int nombreApres = grille.getFormesPresentes().size();

        verifier(nombreAvant == 1, "La forme initiale n'a pas été détectée");
        verifier(nombreApres == 1, "Le nombre de formes doit être conservé");
    }

    private static void verifier(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
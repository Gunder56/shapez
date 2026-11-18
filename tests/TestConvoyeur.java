package tests;

import src.Cardinal;
import src.Cellule;
import src.CelluleOriente;
import src.Forme;
import src.Tapis;

public class TestConvoyeur {
    public static void main(String[] args) {
        Cellule cellule = new Cellule(0, 0);
        Tapis tapis = new Tapis(cellule, Cardinal.EST, Cardinal.OUEST);

        if (!tapis.est_disponible()) {
            throw new AssertionError("Un convoyeur vide doit être disponible");
        }

        Forme forme = new Forme(1);
        tapis.stocker_forme(forme);

        if (tapis.est_disponible()) {
            throw new AssertionError("Un convoyeur avec du stockage ne doit pas être disponible");
        }

        tapis.ajouter_forme();

        if (tapis.getForme() != forme
                || tapis.getStockage() != null) {
            throw new AssertionError("Chargement du convoyeur incorrect");
        }

        if (tapis.emplacement() != cellule) {
            throw new AssertionError("emplacement() doit retourner la cellule du convoyeur");
        }

        tapis.extraire_forme();
        if (tapis.getForme() != null
                || !tapis.est_disponible()) {
            throw new AssertionError("Extraction du convoyeur incorrecte");
        }

        Cellule celluleDestination = new Cellule(1, 0);
        tapis.getSorties()[0] = new CelluleOriente(celluleDestination, Cardinal.EST);

        if (tapis.destination() != null) {
            throw new AssertionError("La destination sans machine doit être null");
        }

        Tapis destination = new Tapis(celluleDestination, Cardinal.OUEST, Cardinal.EST);
        tapis.getSorties()[0] = new CelluleOriente(destination.emplacement(), Cardinal.EST);

        if (tapis.destination() != destination) {
            throw new AssertionError("destination() doit retourner la machine de la sortie");
        }

        tapis.stocker_forme(forme);
        tapis.ajouter_forme();
        tapis.deplacer_forme();

        if (tapis.getForme() != null
                || destination.getForme() != forme) {
            throw new AssertionError("deplacer_forme() doit transférer la forme");
        }

        System.out.println("Convoyeur testé avec succès.");
    }
}

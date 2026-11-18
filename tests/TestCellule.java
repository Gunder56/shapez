package tests;

import src.Cardinal;
import src.Cellule;
import src.CelluleOriente;
import src.Forme;
import src.Tapis;

public class TestCellule {
    public static void main(String[] args) {
        Cellule cellule = new Cellule(0, 0);

        if (cellule.getX() != 0 || cellule.getY() != 0 || !cellule.est_libre()) {
            throw new AssertionError("Construction de la cellule incorrecte");
        }

        System.out.println("Cellule construite avec succès.");
    }
}

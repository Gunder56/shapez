package tests;

import src.Cardinal;
import src.Cellule;
import src.CelluleOriente;

public class TestCelluleOrientee {
    public static void main(String[] args) {
        Cellule cellule = new Cellule(0, 0);
        CelluleOriente cellule_orientee = new CelluleOriente(cellule, Cardinal.NORD);

        if (cellule_orientee.getCellule() != cellule
                || cellule_orientee.getDirection() != Cardinal.NORD) {
            throw new AssertionError("Construction de la cellule orientée incorrecte");
        }

        System.out.println("Cellule orientée construite avec succès.");
    }
}

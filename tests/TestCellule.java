package tests;

public class TestCellule {
    public static void main(String[] args) {
        Cellule cellule = new Cellule(0, 0);
        System.out.println("Cellule créée avec succès aux coordonnées: (" + cellule.getX() + ", " + cellule.getY() + ")");
    }
}
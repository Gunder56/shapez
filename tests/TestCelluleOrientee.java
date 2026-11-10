package tests;

class TestCelluleOrientee {
    public static void main(String[] args) {
        Cellule cellule = new Cellule(0, 0);
        Cardinal direction = Cardinal.NORD;
        CelluleOrientee celluleOrientee = new CelluleOrientee(cellule, direction);
        System.out.println("Cellule orientée créée avec succès.");
    }
}
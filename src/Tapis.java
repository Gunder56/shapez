package src;

public class Tapis extends Convoyeur {
    private CelluleOriente[] entrees;
    private CelluleOriente[] sorties;

    public Tapis(Cellule cellule, Cardinal entree, Cardinal sortie) {
        if (!cellule.est_libre()) {
            throw new IllegalArgumentException("La cellule doit être vide");
        }

        entrees = new CelluleOriente[] {
            new CelluleOriente(cellule, entree)
        };
        sorties = new CelluleOriente[] {
            new CelluleOriente(cellule, sortie)
        };
        cellule.setMachine(this);
    }

    public CelluleOriente[] getEntrees() {
        return entrees;
    }

    public CelluleOriente[] getSorties() {
        return sorties;
    }
}

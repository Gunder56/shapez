package src;

public class CelluleOriente {
    private Cellule cellule;
    private Cardinal direction;

    public CelluleOriente(Cellule cellule, Cardinal direction) {
        this.cellule = cellule;
        this.direction = direction;
    }

    public Cellule getCellule() {
        return cellule;
    }

    public Cardinal getDirection() {
        return direction;
    }
}

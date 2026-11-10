package src;

class CelluleOrientee {

    private Cellule cellule;  
    private Cardinal direction; 

    public CelluleOrientee(Cellule cellule, Cardinal direction) {
        this.cellule = new Cellule(cellule.getX(), cellule.getY());
        this.direction = direction;
    }
}
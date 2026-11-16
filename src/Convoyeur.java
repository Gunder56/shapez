package src;

abstract class Convoyeur extends Machine {
    private CelluleOriente[] entrees;
    private CelluleOriente[] sorties;
    private Forme forme;
    private Forme stockage;

    protected Convoyeur(CelluleOriente[] entrees, CelluleOriente[] sorties) {
        this.entrees = entrees;
        this.sorties = sorties;
    }

    public boolean est_disponible() {
        return stockage == null;
    }

    public Machine destination() {
        if (sorties[0] == null || sorties[0].getCellule() == null) {
            return null;
        }
        return sorties[0].getCellule().getMachine();
    }

    public void deplacer_forme() {
        if (forme == null) {
            ajouter_forme();
        }

        if (forme == null || destination() == null) {
            return;
        }

        Cellule cellule_destination = sorties[0].getCellule();
        if (cellule_destination.getForme() == null) {
            cellule_destination.setForme(forme);
            forme = null;
        }
    }

    public void extraire_forme() {
        forme = null;
    }

    public void stocker_forme(Forme nouvelle_forme) {
        if (stockage == null) {
            stockage = nouvelle_forme;
        }
    }

    public void ajouter_forme() {
        if (forme == null && stockage != null) {
            forme = stockage;
            stockage = null;
        }
    }

    public Cellule emplacement() {
        return entrees[0].getCellule();
    }

    public Forme getForme() {
        return forme;
    }

    public Forme getStockage() {
        return stockage;
    }
}

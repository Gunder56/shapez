package src;

public class Tapis extends Convoyeur {
    public Tapis(Cellule cellule, Cardinal entree, Cardinal sortie) {
        super(creerEntrees(cellule, entree), creerSorties(cellule, sortie));
        if (!cellule.est_libre()) {
            throw new IllegalArgumentException("La cellule doit être vide");
        }

        cellule.setMachine(this);
    }

    private static CelluleOriente[] creerEntrees(Cellule cellule, Cardinal entree) {
        return new CelluleOriente[] { new CelluleOriente(cellule, entree) };
    }

    private static CelluleOriente[] creerSorties(Cellule cellule, Cardinal sortie) {
        return new CelluleOriente[] { new CelluleOriente(cellule, sortie) };
    }

    @Override
    public Machine destination() {
        if (getSorties().length == 0
                || getSorties()[0] == null
                || getSorties()[0].getCellule() == null) {
            return null;
        }
        Cellule destination = getSorties()[0].getCellule();
        if (destination == emplacement()) {
            return null;
        }
        return destination.getMachine();
    }
}

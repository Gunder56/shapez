package tests;

public class TestTapis {
    public static void main(String[] args) {
        Cellule cellule = new Cellule(0, 0);
        Tapis tapis = new Tapis(cellule, Cardinal.OUEST, Cardinal.EST);

        if (tapis.getEntrees().length != 1
                || tapis.getSorties().length != 1
                || tapis.getEntrees()[0].getCellule() != cellule
                || tapis.getEntrees()[0].getDirection() != Cardinal.OUEST
                || tapis.getSorties()[0].getCellule() != cellule
                || tapis.getSorties()[0].getDirection() != Cardinal.EST
                || cellule.est_libre()) {
            throw new AssertionError("Construction du tapis incorrecte");
        }

        System.out.println("Tapis construit avec succès.");
    }
}

package tests;

public class TestForme {
    public static void main(String[] args) {
        Forme forme = new Forme(1);

        if (forme.getId() != 1) {
            throw new AssertionError("Construction de la forme incorrecte");
        }

        System.out.println("Forme construite avec succès.");
    }
}

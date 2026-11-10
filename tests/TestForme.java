// tests unitaires de la classe Forme (construction correcte de l’objet)
package tests;

class TestForme {
    public static void main(String[] args) {
        Forme forme = new Forme(1);
        System.out.println("ID de la forme: " + forme.getId());
    }
}
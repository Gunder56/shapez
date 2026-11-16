import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConvoyeurTest {

    private Convoyeur c1;
    private Convoyeur c2;
    private Convoyeur c3;

    @BeforeEach
    public void setUp() {
        // Initialisation fictive : on suppose ici que les convoyeurs 
        // sont placés successivement sur la grille selon les règles établies.
        // c1.destination() renverra c2, et c2.destination() renverra c3.
        c1 = new Convoyeur(); 
        c2 = new Convoyeur();
        c3 = new Convoyeur();
        // Setup de la grille et des cellules omis pour la concision
    }

    // Question 6 : Scénario de test n°3
    @Test
    public void testDeplacementVersConvoyeurVide() {
        Forme forme = new Forme(1);
        c1.setForme(forme); // Le premier contient une forme
        // Le second (c2) est vide par défaut

        c1.deplacer_forme(); // Appel de deplacer_forme sur C1

        assertNull(c1.getForme(), "Le premier convoyeur doit être vide");
        assertEquals(forme, c2.getForme(), "Le second convoyeur doit contenir la forme");
    }

    // Question 7 : Scénario de test n°4
    @Test
    public void testDeplacementVersConvoyeurOccupe() {
        Forme forme1 = new Forme(1);
        Forme forme2 = new Forme(2);
        
        c1.setForme(forme1); // Le premier contient forme1
        c2.setForme(forme2); // Le second contient forme2

        c1.deplacer_forme(); // Appel de deplacer_forme sur C1

        assertEquals(forme1, c1.getForme(), "Le premier convoyeur doit toujours contenir forme1");
        assertEquals(forme2, c2.getForme(), "Le second convoyeur doit toujours contenir forme2");
    }

    // Question 8 : Scénario de test n°5
    @Test
    public void testDeplacementApresLiberationDestination() {
        Forme forme1 = new Forme(1);
        Forme forme2 = new Forme(2);
        
        c1.setForme(forme1);
        c2.setForme(forme2);

        c1.deplacer_forme(); // Tentative de déplacement (échoue)
        
        c2.extraire_forme(); // Suppression de la forme sur le convoyeur 2
        
        c1.deplacer_forme(); // Nouvel appel de deplacer_forme sur C1

        assertNull(c1.getForme(), "Le premier convoyeur doit être vide");
        assertEquals(forme1, c2.getForme(), "Le second convoyeur doit contenir forme1");
    }

    // Question 9 : Scénario de test n°6 (Transport successif de plusieurs formes sur une même ligne)
    @Test
    public void testTransportSuccessifPlusieursFormes() {
        Forme f1 = new Forme(1);
        Forme f2 = new Forme(2);
        Forme f3 = new Forme(3);

        // Insertion et avancement de f1
        c1.setForme(f1);
        c1.deplacer_forme(); // f1 passe sur c2
        
        // Insertion de f2 et avancement général
        c1.setForme(f2);
        c2.deplacer_forme(); // f1 passe sur c3
        c1.deplacer_forme(); // f2 passe sur c2
        
        // Insertion de f3 et avancement général
        c1.setForme(f3);
        c3.deplacer_forme(); // f1 sort de la ligne (ou stockée)
        c2.deplacer_forme(); // f2 passe sur c3
        c1.deplacer_forme(); // f3 passe sur c2

        assertEquals(f3, c2.getForme(), "C2 doit contenir f3");
        assertEquals(f2, c3.getForme(), "C3 doit contenir f2");
    }
}
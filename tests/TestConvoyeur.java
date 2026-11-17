package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import model.Forme;
import model.Convoyeur;

public class ConvoyeurTest {

   
    @Test
    void scenarioTest1_ConvoyeurVideAvecStockage() {
       
        Forme formeStockee = new Forme();
        Convoyeur convoyeur = new Convoyeur();
        convoyeur.setStockage(formeStockee); 

        convoyeur.ajouterForme();

        assertNotNull(convoyeur.getForme(), "L'attribut forme ne devrait pas être null");
        assertEquals(formeStockee, convoyeur.getForme(), "La forme du convoyeur doit être celle qui était dans le stockage");

        System.out.println("Scénario de test n°1 réalisé avec succès");
    }

   
    @Test
    void ajouterFormeTest() {
        Forme forme = new Forme();
        Convoyeur convoyeur = new Convoyeur();

        convoyeur.ajouterForme(forme);

        assertNotNull(convoyeur.getForme());
        assertNull(convoyeur.getStockage());
        System.out.println("test ajouterformeTest réalisé avec succès");
    }

    @Test
    void stockeformeTest() {
        Forme forme = new Forme();
        Convoyeur convoyeur = new Convoyeur();

        try {
            convoyeur.stockerForme(forme);
        } catch (Exception e) {
            
        }
        assertNotNull(convoyeur.getStockage());
        System.out.println("test ajouterstockage réalisé avec succès");

        try {
            convoyeur.stockerForme();
            assertNotNull(convoyeur.getStockage());
        } catch (Exception e) {}
        System.out.println("test n°2 sur stockerforme réalisé avec succès");

        try {
            convoyeur.ajouterForme();
            assertNotNull(convoyeur.getStockage());
            assertNotNull(convoyeur.getForme());
        } catch (Exception e) {}
        System.out.println("test n°2bis sur stockerforme réalisé avec succès");
    }
}

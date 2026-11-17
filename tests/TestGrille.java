@Test
void scenarioTest10_ConservationListeFormes() {
    // 1. Création de la grille et d'un circuit fermé de convoyeurs (orientations variées)
    Grille grille = new Grille(3, 3);
    
    Tapis tapis1 = new Tapis(new Cellule(0, 0), Cardinal.Ouest, Cardinal.Est);
    Tapis tapis2 = new Tapis(new Cellule(0, 1), Cardinal.Ouest, Cardinal.Sud);
    Tapis tapis3 = new Tapis(new Cellule(1, 1), Cardinal.Nord, Cardinal.Ouest);
    Tapis tapis4 = new Tapis(new Cellule(1, 0), Cardinal.Est, Cardinal.Nord); // Tapis vide

    // Ajout des convoyeurs à la grille (selon votre constructeur/méthode d'ajout)
    grille.ajouter(tapis1);
    grille.ajouter(tapis2);
    grille.ajouter(tapis3);
    grille.ajouter(tapis4);

    // 2. Création et placement des formes (certains tapis restent vides)
    Forme f1 = new Forme(1);
    Forme f2 = new Forme(2);

    tapis1.stocker_forme(f1);
    tapis1.ajouter_forme();

    tapis3.stocker_forme(f2);
    tapis3.ajouter_forme();

    // 3. Récupération dynamique des formes présentes avant update()
    List<Forme> formesAvant = grille.getFormesPresentes();

    // 4. Appels répétés à update() sur la grille
    for (int i = 0; i < 10; i++) {
        grille.update();
    }

    // 5. Récupération dynamique des formes après update() et vérification
    List<Forme> formesApres = grille.getFormesPresentes();

    assertEquals(formesAvant.size(), formesApres.size(), 
        "Le nombre de formes sur la grille doit rester identique.");
    assertTrue(formesAvant.containsAll(formesApres) && formesApres.containsAll(formesAvant), 
        "La liste des formes présentes sur la grille doit être la même.");
}

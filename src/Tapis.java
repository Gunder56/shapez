package src;

public class Tapis {
    private CelluleOriente[1] entrees;
    private CelluleOriente[1] sorties;


    Tapis(Cellule cell, CelluleOrienter entrer, Cardinal sortie){
        entrees = entrer;
        sorties = sortie;
        cell.est_libre() = false;
    }
}

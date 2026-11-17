package src;

public class Grille {

   private Cellule[][] grille;

   public Grille(Cellule[][] grille) {
       this.grille = grille;
    }

    public Grille() {

        grille = new Cellule[10][10];

    



   }


   public void update(){


    // mise à jour de la grille:
    /*
    chaque convoyeur contenant une forme

    on déplace la forme dans l'autre convoyeur si il'est disponible
    on extrait la forme du convoyeur si il n'y a pas de convoyeur disponible

    on stocke la forme

     */

    Convoyeur[] convoyeurs = new Convoyeur[0];

    for(Convoyeur convoyeur:convoyeurs){

        


       

            if(convoyeur.destinantion().est_disponible()){

               convoyeur.extraire_forme();
               convoyeur.destinantion().stocker_forme(convoyeur.getForme());   


            



        }

            while(!convoyeur.est_disponible()){

                   convoyeur.ajouter_forme();
        }
        
    }







   }






    
}

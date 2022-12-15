package uqac.dim.projet_gestion.Control;

import uqac.dim.projet_gestion.Model.*;

public class Controller {

    String[] badCharacters = new String[] {"!","/","|","\\","@","#","$","%","?","&","*"};

    public void askInfo(String[] infosNeeded ){
        String[] Infos = new String[infosNeeded.length];
        for(String infoNeeded : infosNeeded ){
            boolean goodEntry = false;
            while(!goodEntry){
                // affiche la question : "Veiller entré l'information suivante -> " + infoNeeded
                String cin = "";
                if(testEntry(cin) == 0){
                    // infosNeeded.
                }
            }

        }
    };

    public int testEntry(String entry){  // 0 -> Entrée Valide 1-> trop court 2-> trop long 3-Charactere non valide 4-...


        if( entry.length() < 5 ){
            return 1;
        }
        if( entry.length() > 30 ){
            return 2;
        }

        for(String badCharacter : badCharacters){                                 //     Vérification 3 : caractères spéciaux
            if(entry.contains(badCharacter)){                                     //
                return 3;      // il y a un mauvais charactere dans l'entrée      //
            }                                                                     //
        }                                                                         //

        // ici on fait les autres vérifications

        return 0;  // aucun des test ne dévoile d'erreurs
    };

}

package modele;

import java.util.HashMap;

public class Reponse {

	// notre réponse est composé d'un integer pour le numero de la question + d'un tableau de String pour les réponses
    private HashMap<Integer,String[]> TotalReponse = new HashMap<Integer,String[]>();

    //GETTER
    public HashMap<Integer, String[]> getTotalReponse() {
        return TotalReponse;
    }

    //SETTER
    public void setTotalReponse( int numQuestion, String[] mesReponses) {
        TotalReponse.put(numQuestion,mesReponses);
    } 

}
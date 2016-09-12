/**
 * 
 */
package modele;

import java.util.ArrayList;

public class Questionnaire {

	//ATTRBITUS
    private int                    identifiant;
    private ArrayList<Question>    mesQuestions = new ArrayList<Question>();
    
    
    

    //CONSTRUCTEUR VIDE 
    
    public Questionnaire () {
    	
    }
    
    
    
    
    //GETTERS ET SETTERS
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public ArrayList<Question> getMesQuestions() {
        return mesQuestions;
    }

    public void setMesQuestions(Question maQuestion) {
        this.mesQuestions.add(maQuestion);
    }

}
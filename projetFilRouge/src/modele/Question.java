/**
 * 
 */
package modele;

import java.util.ArrayList;

/**
 * @Geoffroy
 *
 * 
 */
public class Question {
	
	/*Attribut modele*/ 
	
	private int    					  numQuestion;
	private int                       niveauDifficulte;
	private String 					  intituleQuestion;
	private ArrayList<Proposition>    listProposition   =  new ArrayList<Proposition>(); 
	
	
	/*constructeur*/

	public Question () {
		
	}
	 
	/*getter et setter*/
	
	/**
	 * @return the numQuestion
	 */
	public int getNumQuestion() {
		return numQuestion;
	}


	/**
	 * @return the intituleQuestion
	 */
	public String getIntituleQuestion() {
		return intituleQuestion;
	}


	/**
	 * @return the listProposition
	 */
	public ArrayList<Proposition> getListProposition() {
		return listProposition;
	}

	public int getNiveauDifficulte() {
		return niveauDifficulte;
	}
	/**
	 * @param numQuestion the numQuestion to set
	 */
	public void setNumQuestion(int numQuestion) {
		this.numQuestion = numQuestion;
	}


	/**
	 * @param intituleQuestion the intituleQuestion to set
	 */
	public void setIntituleQuestion(String intituleQuestion) {
		this.intituleQuestion = intituleQuestion;
	}


	/**
	 * @param listProposition the listProposition to set
	 */
	public void setListProposition(Proposition listProposition) {
		this.listProposition.add(listProposition) ;
	}


	public void setNiveauDifficulte(int niveauDifficulte) {
		this.niveauDifficulte = niveauDifficulte;
	}
	 

}

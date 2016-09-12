package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Proposition;
import modele.Question;
import modele.Questionnaire;
import modele.Reponse;

/**
 * Servlet implementation class ServletQCM
 */
@WebServlet("/ServletQCM")
public class ServletQCM extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletQCM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}
	
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On initialise des questions pour bouchonner
		Question question1 = new Question();
		question1.setNumQuestion(1) ; 
		question1.setIntituleQuestion("intitulé question 1") ;
		question1.setNiveauDifficulte(7);
		question1.setListProposition(new Proposition(1,"prop1",0));
		question1.setListProposition(new Proposition(2,"prop2",1));
		
		Question question2 = new Question();
		question2.setNumQuestion(2);
		question2.setIntituleQuestion("intitulé question 2");
		question2.setNiveauDifficulte(7);
		question2.setListProposition(new Proposition(1,"prop1",0));
		question2.setListProposition(new Proposition(2,"prop2",1)); 
		question2.setListProposition(new Proposition(3,"prop3",0));
		
		//On initialise un questionnaire composé de question pour bouchonner
		Questionnaire monQCM = new Questionnaire();
		monQCM.setIdentifiant(1);
		monQCM.setMesQuestions(question1);
		monQCM.setMesQuestions(question2);
		
		//on initialise notre objet réponse (composé du numéro de question ET de la collection de réponses choisis)
  		Reponse mesReponses = new Reponse() ;
		
		//ICI le conteneur qui stocke les variables de sessions
		HttpSession  maSession = request.getSession(); //recupêrer l'attribut "session" de la requete
		
		//ICI on déclare les variables que l'on va utiliser
		
		//un compteur
		int compteurQuestion = 0 ;
		
		//les variables de sessions
		System.out.println("Compteur "+compteurQuestion);
        maSession.setAttribute("numQuestion",compteurQuestion); //le num de question est calqué sur le compteur
        maSession.setAttribute("questionnaire", monQCM);	// on indique le QCM
        maSession.setAttribute("Question", monQCM.getMesQuestions().get(compteurQuestion) ); //question fait référence au QCM / on va chercher la question a la "cellule" compteur question
				        	      		
  		//On déclare notre reponse comme étant une variable de session
  		maSession.setAttribute("reponses", mesReponses); // et c'est cet objet mesReponses que l'on va manipuler sous la forme : maSession.getAttribute("reponses")
      		
        
		getServletContext().getRequestDispatcher("/WEB-INF/QCM.jsp").forward(request,response) ;
	}
	
		

}

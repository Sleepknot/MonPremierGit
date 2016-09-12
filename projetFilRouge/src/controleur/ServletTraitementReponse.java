package controleur;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Question;
import modele.Questionnaire;
import modele.Reponse;


@WebServlet("/ServletTraitementReponse")
public class ServletTraitementReponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletTraitementReponse() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}
	
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession maSession = request.getSession();
        Questionnaire monQCM = (Questionnaire) maSession.getAttribute("questionnaire");
		
		Question RecupQuestion = new Question();
		String[] listRepFrom ;
		Reponse recupReponse = (Reponse) maSession.getAttribute("reponses");
	
		RecupQuestion = (Question) request.getSession().getAttribute("Question"); //on va chercher l'attribut question
		
		
		//recuperer le numero de la question
		System.out.println("Num question: " + RecupQuestion.getNumQuestion());
		
		//recuperer les propositions et les etats associés
		if (request.getParameterValues("rep_case") == null){
			listRepFrom = request.getParameterValues("rep_radio");
			recupReponse.setTotalReponse((int)maSession.getAttribute("numQuestion"), listRepFrom);
			
			
		}else{
			listRepFrom = request.getParameterValues("rep_case");
			recupReponse.setTotalReponse((int)maSession.getAttribute("numQuestion"), listRepFrom);
		}
		

		for(int i = 0 ; i < listRepFrom.length ; i++){
			System.out.println(listRepFrom[i]);
		}	

        maSession.setAttribute("numQuestion", (int)request.getSession().getAttribute("numQuestion")+1); 				//on prend le numero de question de la requéte et on ajoute 1
        maSession.setAttribute("questionnaire", monQCM); //le QCM ne change pas
       
        //condition de sortie du questionnaire
        
        
        //si on est pas sorti de l'array list, on affiche la suite du questionnaire
        if ((int)maSession.getAttribute("numQuestion")<(int)monQCM.getMesQuestions().size()){
        	 maSession.setAttribute("Question", monQCM.getMesQuestions().get((int)maSession.getAttribute("numQuestion")) );
        	 getServletContext().getRequestDispatcher("/WEB-INF/QCM.jsp").forward(request,response) ;
        	 
        }else { //Sinon, on affiche une page aurevoir
        	System.out.println("on est sorti") ;
        	
        	
        	//for (int index=0 ; index < listRepFrom.length ; index ++ ) {
        	//	System.out.println(reponses);        		
        	//}
 
        	for(Entry<Integer, String[]> entry : recupReponse.getTotalReponse().entrySet()) {
        	    Integer cle 	= entry.getKey();
        	    String[] valeur = entry.getValue();
        	    
        	    // traitements
        	    System.out.println( "la cle : " +cle ) ;
        	    
        	    for (int i=0 ; i<valeur.length ; i++ ) {
            	    System.out.println( "la valeur " +i +" : "  +valeur[i] ) ;
            	    
        	    	
        	    }
        	    	
        	}
        	
        	getServletContext().getRequestDispatcher("/WEB-INF/FIN.jsp").forward(request,response) ;
        	
        }

		
	}
}

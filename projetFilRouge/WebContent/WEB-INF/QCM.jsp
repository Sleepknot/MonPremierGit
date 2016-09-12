<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>Insert title here</title>
	</head>
	<body>
		
		 <!-- Bloc Question -->
		 
		 <form method="post" action="ServletTraitementReponse">
		 
			<div id ="" class="BlocQuestion">
			
				<div class="NumQuestion" >
					<p><c:out value ="Numero de la question : ${Question.numQuestion}"/></p>
				
				</div>
				<div id ="" class="IntituleQuestion">
					<p><c:out value ="Intitulé : ${Question.intituleQuestion}"/></p>
				</div>
					
			</div>
		
		
		
			<!-- Bloc Proposition -->
			
			<!-- Si le nb de proposition est superieur a 2 alors c'est des cases a cocher Sinon c'est des Btn radio -->
			<c:choose>
    		<c:when test="${Question.listProposition.size() > 2 }">
    			<!-- Affichage de la liste des cases a cocher -->
    			<c:forEach  items ="${Question.listProposition}" var="propositionReponse"  varStatus ="compteur">
	    			<tr>
			    		<td> <label for="case${compteur.index}"><c:out value="${propositionReponse.libelle_Prop}"/></label>
			    		<td> <input name= "rep_case" type="checkbox" id="case${compteur.index}"  value="${compteur.index}"> <br/> </td> 
			 		</tr>
		 		</c:forEach> 
    		</c:when>
    		<c:otherwise>
    		
    			<!-- Affichage de la liste des Btn radio -->
    			<c:forEach  items ="${Question.listProposition}" var="propositionReponse"  varStatus ="compteur">    			
	    			<tr>
	    				<td> <input name= "rep_radio" type="radio" value="${compteur.index}"> <c:out value="${propositionReponse.libelle_Prop}"/> <br> </td>
			 		</tr>
		 		</c:forEach>  
    		</c:otherwise>
			</c:choose>
			
			<input type="submit"  value="valider"/>
			
		</form>
	</body>
</html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Accueil</title>
	</head>
	
	<body>
	
		<p><c:out value ="Aurevoir"/></p>
		
		<!-- ici on va afficher le score -->
		
			<!-- il faut remonter les choix de reponses -->
			<c:out value=" Test d'affichage d'une reponse : ${ propositionReponse.repCorrecte }"> </c:out>
			
			<!-- il faut remonter les choix de reponses -->
			
			<!-- il faut remonter les choix de reponses -->
		
		<!-- Ici on propose de faire un autre questionnaire (bouchonage : on relance le même) -->
		<p><a href="ServletQCM" > Cliquez ici pour commencer un nouveau questionnaire</a></p>
		
	</body>
	
</html>
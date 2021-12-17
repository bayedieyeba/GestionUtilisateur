<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Connxion</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/design.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css" />">
</head>
<body>
  <div id="entete">Gestion des utilisateurs</div>
	<div id="menu">
		<ul>
			<li><a href="<c:url value=""/>">Accueil</a></li>
			<c:choose>
				
					<c:when test="${ !empty sessionScope.utilisateur }">
						<li><a href="<c:url value='/users/list' />">Lister</a></li>
						<li><a href="<c:url value='/users/add' />">Ajouter</a></li>
						<li><a href="<c:url value='/lodout' />">Déconnexion</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<c:url value='/login'/>">Connexion</a></li>
					</c:otherwise>
			</c:choose>
		</ul>
	</div>
  <div id="corps">
  		<h1 id="titre-principal"> Page de Connexion</h1>
	    <form method="post">
			<div class="formItem">
				<label>Login</label>
				<input type="text" name="login" value="${login }" >
			</div>
			<div class="formItem">
				<label>Password</label>
				<input type="password" name="password" >
			</div>
			<div class="formItem">
				<label></label>
				<button type="submit"  class="btn btn-primary">Connexion </button>
			</div>
		</form>
 </div>
</body>
</html>
<%@page import="beans.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="utilisateur" class="beans.Utilisateur" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modifier utilisateur</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/design.css" />">
</head>
<body>
	<div id="entete">Gestion des utilisateurs</div>
	<div id="menu">
		<ul>
			<li><a href="/">Accueil</a></li>
			<li><a href="users/list">Lister</a></li>
			<li><a href="users/add">Ajouter</a></li>
		</ul>
	</div>
	<div id="corps">
			<c:if test="${ !empty form }">
				<div id="statusMessageBox" class="alert alert-${ form.status ? 'success' : 'danger' }">
					<span id="control" onclick="hideMesageBox()" title="fermer">x</span>
					${ form.statusMessage }
				</div>
			</c:if>
			<h1 id="titre-principal">Ajout d'un utilisateur</h1>
			<form action="" method="post">
					<div class="formItem">
						<label>Nom</label>
						<input type="text" name="nom" value="${requestScope.utilisateur.nom }">
						<span class="erreur">${form.erreurs.nom}</span>
					</div>
					<div class="formItem">
						<label>Prenom</label>
						<input type="text" name="prenom" value="${ requestScope.utilisateur.prenom }">
						<span class="erreur"> ${ form.erreurs}</span>
					</div>
					<div class="formItem">
						<label>Login</label>
						<input type="text" name="login" value="${requestScope.utilisateur.login }">
						<span class="erreur">${form.erreurs.login}</span>
					</div>
					<div class="formItem">
						<label>Password</label>
						<input type="password" name="password" value="${requestScope.utilisateur.password }">
						<span class="erreur" >${form.erreurs.password}</span>
					</div>
					<div class="formItem">
						<label>Password (bis)</label>
						<input type="password" name="passwordBis">
						<span class="erreur" >${form.erreurs.passwordbis}</span>
					</div>
					<div class="formItem">
						<label></label>
						<input type="submit" value="mdifier">
					</div>
			</form>
	</div>
	<div id="pied">footer</div>
</body>
</html>
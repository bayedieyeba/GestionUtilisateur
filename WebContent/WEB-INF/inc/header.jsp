<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Gestion des Utilisateurs </title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/design.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css" />">
	<script src="<c:url value="js/script.js" />"></script> 
	</head>
	<body>
		<div id="entete" >Gestion des Utilisateurs</div>
		 
		<div id="menu">
		<ul>
			<li><a href="<c:url value=""/>">Accueil</a></li>
			<c:choose>
				
					<c:when test="${ !empty sessionScope.utilisateur }">
						<li><a href="<c:url value='/users/list' />">Lister</a></li>
						<li><a href="<c:url value='/users/add' />">Ajouter</a></li>
						<li><a href="<c:url value='/logout' />">Déconnexion</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="<c:url value='/login'/>">Connexion</a></li>
					</c:otherwise>
			</c:choose>
		</ul>
		</div>
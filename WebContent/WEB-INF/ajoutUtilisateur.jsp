<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:import url="inc/header.jsp"/>
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
						<input type="text" name="nom" value="${form.utilisateur.nom }">
						<span class="erreur">${form.erreurs.nom}</span>
					</div>
					<div class="formItem">
						<label>Prenom</label>
						<input type="text" name="prenom" value="${ form.utilisateur.prenom }">
						<span class="erreur"> ${ form.erreurs.nom}</span>
					</div>
					<div class="formItem">
						<label>Login</label>
						<input type="text" name="login" value="${form.utilisateur.login }">
						<span class="erreur">${form.erreurs.login}</span>
					</div>
					<div class="formItem">
						<label>Password</label>
						<input type="password" name="password">
						<span class="erreur" >${form.erreurs.password}</span>
					</div>
					<div class="formItem">
						<label>Password (bis)</label>
						<input type="password" name="passwordBis">
						<span class="erreur" >${form.erreurs.passwordbis}</span>
					</div>
					<div class="formItem">
						<label></label>
						<input type="submit" value="Ajouter">
					</div>
			</form>
	<c:import url="inc/footer.jsp"/>
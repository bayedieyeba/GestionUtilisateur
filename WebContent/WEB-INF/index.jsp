<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp"/>
		 <div id="corps">
		 		<c:if test="${status}">
		 			<div style="color:green;">
		 				<span id="control" onclick="hideMessageBox()"></span>
		 				${param.message}
		 			</div>
		 		</c:if>
		   
			   <h1 id="titre-principal">Liste des Utilisateurs</h1>
			    <c:choose>
			    	<c:when test="${empty requestScope.utilisateurs }">
			    		<p>La liste est vide </p>
			    	</c:when>
			    	<c:when test="${!empty utilisateurs }">
			    	<div class="container">
			    		<table class="table table-borfered">
			      		
						     <tr> 
						       <th>ID </th>
						       <th>Nom</th>
						       <th>Prenom</th>
						       <th>Login</th>
						       <th colspan="2"  ><center>Actions</center></th>
						     </tr>
						  	  <c:forEach items="${requestScope.utilisateurs}" var="utilisateur">
							  <tr>  
							    	<td> <c:out value="${utilisateur.id }"/> </td> 
							    	<td> <c:out value="${utilisateur.nom }"/> </td>  
							    	<td> <c:out value="${utilisateur.prenom }"/></td>  
									<td> <c:out value="${utilisateur.login }"/></td>  
									
								     <td>  <a href="<c:url value='/update'/>?id=<c:out value="${utilisateur.id }"></c:out>" class="btn btn-outline-primary"> Modifier</a> </td> 
								     <td>  <a href="<c:url value="/delete"/>?id=<c:out value="${utilisateur.id }"></c:out>" class="btn btn-danger"> Supprimer</a> </td>  
							  </tr>
							  
						    </c:forEach>
					  
					    </table>
			    	</div>
			    	</c:when>
			    </c:choose>
			    
	<c:import url="inc/footer.jsp"/>	    
		      		
		

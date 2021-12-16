<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="inc/header.jsp"/>
		 <div id="corps">
		 		<c:if test="${status}">
		 			<div>
		 				<span id="control" onclick="hideMessageBox()">x</span>
		 				${param.message}
		 			</div>
		 		</c:if>
		   
			   <h1 id="titre-principal">Liste des Utilisateurs</h1>
			    <c:choose>
			    	<c:when test="${empty requestScope.utilisateurs }">
			    		<p>La liste est vide </p>
			    	</c:when>
			    	<c:when test="${!empty utilisateurs }">
			    		<table>
			      		
						     <tr> 
						       <th>ID </th>
						       <th>Nom</th>
						       <th>Prenom</th>
						       <th>Login</th>
						       <th colspan="2">Actions</th>
						     </tr>
						  	  <c:forEach items="${requestScope.utilisateurs}" var="utilisateur">
							  <tr>  
							    	<td> <c:out value="${utilisateur.id }"/> </td> 
							    	<td> <c:out value="${utilisateur.nom }"/> </td>  
							    	<td> <c:out value="${utilisateur.prenom }"/></td>  
									<td> <c:out value="${utilisateur.login }"/></td>  
									
								     <td>  <a href="<c:url value='/update'/>?id=<c:out value="${utilisateur.id }"></c:out>"> Modifier</a> </td> 
								     <td>  <a href="<c:url value="/delete"/>?id=<c:out value="${utilisateur.id }"></c:out>"> Supprimer</a> </td>  
							  </tr>
						    </c:forEach>
					  
					    </table>
			    
			    	</c:when>
			    </c:choose>
			    
	<c:import url="inc/footer.jsp"/>	    
		      		
		

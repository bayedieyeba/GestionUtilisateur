package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisteurDao;
import metier.AddUserForm;


@WebServlet("/users/add")
public class AddUser extends HttpServlet {
	
	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajoutUtilisateur.jsp";
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Object form = session.getAttribute("form");
    	
    	if( form != null) {
    		session.removeAttribute("form");
    	}
    	
    	request.setAttribute("form", form);
    	getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddUserForm form = new AddUserForm(request);
		
		HttpSession session = request.getSession();
		session.setAttribute("form", form);
		
		if(form.ajouter()) {
			String url = request.getContextPath() + "/users/list" + "?message="+ form.getStatusMessage();
			
			response.sendRedirect(url);
		}
		else {
			response.sendRedirect(request.getContextPath() +"/users/add");
		}
	}

}

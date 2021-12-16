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
import metier.ModifierUser;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if( id != null && id.matches("[0-9]+")) {
			Utilisateur utilisateur = UtilisteurDao.get(Integer.parseInt(id));
			if(utilisateur != null) {
				HttpSession session = request.getSession();
				request.setAttribute("utilisateur", utilisateur);
				
				Object form = session.getAttribute("form");
				if(form != null) {
					session.removeAttribute("form");
				}
				request.setAttribute("form", form);
				getServletContext().getRequestDispatcher("/WEB-INF/modifier.jsp").forward(request, response);
			}
		}
		response.sendRedirect(request.getContextPath()+"/users/list");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("id");
//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		String login = request.getParameter("login");
//		String password = request.getParameter("password");
//		
//		if( id != null && id.matches("[0-9]+")) {
//			
//			Utilisateur utilisateur = new Utilisateur(Integer.parseInt(id), nom, prenom, login, password);
//			
//			UtilisteurDao.modifier(utilisateur);
//			
//		}
//		response.sendRedirect(request.getContextPath()+"/users/list");
		
    ModifierUser form = new ModifierUser(request);
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("form", form);
		
		if(form.modifer()) {
			String url = request.getContextPath() + "/users/list" + "?message="+ form.getStatusMessage();
			
			response.sendRedirect(url);
		}
		else {
			response.sendRedirect(request.getContextPath() +"/update?id="+id);
		}
		

	}

}

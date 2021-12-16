package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisteurDao;
import metier.LoginForm;


@WebServlet({"", "/login","/logout"})
public class Connextion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VUE_CONNEXION = "/WEB-INF/connexion.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getServletPath()) {
		case "":
		case "/login":
			getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
			break;

		default:
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginForm form = new LoginForm(request);
		
		if(form.authentifier()) {
			
			response.sendRedirect(request.getContextPath() +"/users/list");
			
		}
		else {
			request.setAttribute("login", form.getLogin());
			getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}
		
		
	}


}

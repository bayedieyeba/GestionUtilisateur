package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisteurDao;


@WebServlet("/users/list")
public class Accueil extends HttpServlet {
	
	private static final String VUE_LIST_USERS = "/WEB-INF/index.jsp";
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session =request.getSession();
    	Object form = session.getAttribute("form");
    	
    	boolean status = false;
    	
    	if( form != null) {
    		session.removeAttribute("form");
    		status = true;
    	}
    	
    	request.setAttribute("status", status);
    	request.setAttribute("utilisateurs", UtilisteurDao.lister());
    	getServletContext().getRequestDispatcher(VUE_LIST_USERS).forward(request, response);
    	
    }


}

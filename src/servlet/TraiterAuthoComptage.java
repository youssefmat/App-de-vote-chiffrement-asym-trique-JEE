package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CoManager;
import dao.GestionBd;

@WebServlet("/TraiterAuthoCo")
public class TraiterAuthoComptage extends HttpServlet {
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		GestionBd bd = new GestionBd();
		CoManager c = new CoManager(email, password);
		// Si le CoManger a bien entré ces informations on le redérige vers sa page d'accueil
		if(bd.findCoManager(c)) {
			getServletContext().getRequestDispatcher("/Comptage.jsp").forward(request, response);
		}else {
			// Sinon on lui affiche une message d'erreur
			HttpSession session = request.getSession(true);
			String erreur = "Erreur : L&#039;adresse e-mail ou le mot de passe que vous avez saisi(e) n&#039;est pas associ&eacute;(e) &agrave; un compte.";
		    String page = "/authCO.jsp";
			session.setAttribute("erreur", erreur);
			session.setAttribute("page", page);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		}
	}

}

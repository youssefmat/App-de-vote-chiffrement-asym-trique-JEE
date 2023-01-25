package servlet;

import cryptages.CrypteMessage;
import dao.Employe;
import dao.GestionBd;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TraiterVotant")
public class TraiterVotant extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("/TraiterCo");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("********	Votant	  ********");
		// récuperer les informations de vote à la formulaire
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String datenaissance = request.getParameter("datenaissance");
		String iden = request.getParameter("identification");
		String bulltinvote = request.getParameter("bulltinvote");
		GestionBd bd = new GestionBd();
		// stocker les formations de la formulaire dans l'objet Employe
		Employe e = new Employe(nom, prenom, datenaissance, iden);
		// vérifier l'objet employe il existe dans la base de donnée 
		if(bd.findEmploye(e)) {
			try {
				CrypteMessage messageCrypter = new CrypteMessage();
				String message1 = nom + ";;" + prenom + ";;" + datenaissance + ";;" + iden;
				String message2 = iden + ";;" + bulltinvote;
				// en crypte les message1 et message2 avec la methode encrypteMessage 
				message1 = messageCrypter.encrypteMessage(message1, "publickeyco.asc");
				message2 = messageCrypter.encrypteMessage(message2, "publickeyde.asc");
				System.out.println("message 1:"+message1);
				System.out.println("message 2:"+message2);
				System.out.println("les messages from Votant sont chiffrés avec succés .-> message1:"+message1+"-> message2:"+message2);
				// stocker les messages from Votant  dans les fichiers 
				File f1 = new File("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/co/IdentificationCO");
				File f2 = new File("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/co/BulltinCO");
				//File f3 = new File("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/de/BulltinCoDe");
				File f4 = new File("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/de/BulltinDE");
				FileWriter myWriterIde    = new FileWriter(f1);
				FileWriter myWriterBullCO = new FileWriter(f2);
				//FileWriter myWriterBullDe = new FileWriter(f3);
				FileWriter myWriterBullDE = new FileWriter(f4);
			    myWriterIde.write(message1.toString());
			    myWriterBullCO.write(message2.toString());
			    //myWriterBullDe.write(message2.toString());
			    myWriterBullDE.write(message2.toString());
			    myWriterIde.close();
			    myWriterBullCO.close();
			    //myWriterBullDe.close();
			    myWriterBullDE.close();
				System.out.println("les messages from Votant sont stocke dans les fichiers  avec succés .");
	
				} catch (Exception ex) {
				System.out.println("error de crypte le  message ou le vote !!"+ex.getMessage());
				ex.printStackTrace();
			}
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/TraiterCo");
			rd.forward(request, response);
		}else {
			HttpSession session = request.getSession(true);
			String msgErreur = "Erreur : Employ&eacute;(e) non trouv&eacute;(e).";
		    String pageAuth = "/form.jsp";
			session.setAttribute("erreur", msgErreur);
			session.setAttribute("page", pageAuth);
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
		}
	}
	

}

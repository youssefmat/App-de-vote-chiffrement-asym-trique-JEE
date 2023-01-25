	package servlet;

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

import cryptages.CrypteMessage;
import cryptages.DecrypteMessage;
import cryptages.ReadFile;
import dao.Covotant;
import dao.GestionBd;


@WebServlet("/TraiterCo")
public class TraiterComptage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n\n********	Centre de Comptage CO	********");
		GestionBd bd = new GestionBd();
		try {
		DecrypteMessage messageDecrypter = new DecrypteMessage();
		System.out.println("CO a recu les deux messages from Votant IdentificationCO et BulltinCO avec succés .");
		messageDecrypter.decrypteFile("co/IdentificationCO", "privatekeyco.asc", "co/output.txt");
		System.out.println("Le message IdentificationCO est déchiffré avec succés .");
		ReadFile readfile = new ReadFile();
		// récuperer les messages dans les fichiers et  stocker dans les variables msg1 et msg2
		String msg1 = readfile.readfile("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/co/output.txt");
		String msg2 = readfile.readfile("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/co/BulltinCO");
		String nom = null, prenom = null, datenaissance = null, identification = null, bulltinvote = null;
		String donne[] = msg1.split(";;");
		nom = donne[0];
		prenom = donne[1];
		datenaissance = donne[2];
		identification = donne[3];
		bulltinvote = msg2;

		Covotant covotant = new Covotant(nom, prenom, datenaissance, identification, bulltinvote);
		System.out.println("Le votant est  :  "+covotant.getNom() + " " + covotant.getPrenom() + " --- Identification: "+covotant.getIdentification());
		if (bd.setCoVotant(covotant) == true) {
			CrypteMessage messageCrypter = new CrypteMessage();
			msg2 = messageCrypter.encrypteMessage(msg2, "publickeyde.asc");
			System.out.println("Le message BulltinCO est chiffré une autre fois avec succés .");
			
			File f = new File("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/de/BulltinCoDe");
			FileWriter myWriterBullCD = new FileWriter(f);
			myWriterBullCD.write(msg2.toString());
			myWriterBullCD.close();
			System.out.println("CO a envoyé le message BulltinCoDe au centre DE avec succés .");
		} else {
			String err = "Ce votant est deja vote" + covotant.getIdentification();
			request.setAttribute("err", err);
		}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/TraiterDe");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

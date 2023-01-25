package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cryptages.DecrypteMessage;
import cryptages.ReadFile;
import dao.Devotant;
import dao.GestionBd;


@WebServlet("/TraiterDe")
public class TraiterDepouillement extends HttpServlet {
	
	private static final long serialVersionUID = -3216834111490165759L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n\n********	Centre de Depouillement	   ********");
		DecrypteMessage dec = new DecrypteMessage();
		GestionBd bd = new GestionBd();

		try {
			  
			Thread.sleep(12000);
		} catch (Exception e1) {
			
			System.out.println("Error dans TraiterDe Key password !! :"+e1.getMessage());
		}
		try {   System.out.println("\n °°°°°	décheffré le file °°°°°	   ********");
		
				dec.decrypteFile("de/BulltinCoDe", "privatekeyde.asc", "de/BulltinCoDe1");
				System.out.println("Le message BulltinCoDe est déchiffré avec succés .");
				
				dec.decrypteFile("de/BulltinCoDe1", "privatekeyde.asc", "de/outputCo.txt");		
				System.out.println("Le message BulltinCoDe est déchiffré une autre fois avec succés .");
				
				dec.decrypteFile("de/BulltinDE", "privatekeyde.asc", "de/outputVotant.txt");
				System.out.println("Le message BulltinDE est déchiffré avec succés .\n");
				
				ReadFile readfile = new ReadFile();
				System.out.println("Lire le fichier où on stoque la bulltin de vote recu from CO aprés le déchiffrement .");
				String msg1 = readfile.readfile("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/de/outputVotant.txt");
				System.out.println(msg1);
				System.out.println("Lire le fichier où on stoque la bulltin de vote recu from Votant aprés le déchiffrement .");
				String msg2 = readfile.readfile("C:/Users/Youssef/eclipse-workspace/app-Vote/messages/de/outputVotant.txt");
				System.out.println(msg2);
				String donne1[] = msg1.split(";;");
				String donne2[] = msg2.split(";;");
				if (donne1[0].compareTo(donne2[0]) == 0 && donne1[1].compareTo(donne2[1]) == 0) {
					Devotant devotant = new Devotant(donne1[0], donne1[1]);
					bd.setDeVotant(devotant);
				}
		} catch (Exception e) {
			System.out.println("error de déchffré le file !: "+e.getMessage());
		}
		getServletContext().getRequestDispatcher("/form.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

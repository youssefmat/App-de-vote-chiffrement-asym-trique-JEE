package cryptages;


import java.io.IOException;
import com.didisoft.pgp.PGPException;
import com.didisoft.pgp.PGPLib;


public class DecrypteMessage {
	

	public DecrypteMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void decrypteFile(String fileName, String privateKeyFile, String output) {
		String path1 = "C:/Users/Youssef/eclipse-workspace/app-Vote/Keys/";
		String path2 = "C:/Users/Youssef/eclipse-workspace/app-Vote/messages/";
		// creer un objet PGPLib
		   PGPLib pgp = new PGPLib();
		 
		   String privateKeyPass = "changeit";
		   try {
		// Décrypte un fichier crypté OpenPGP à l'aide d'une clé d'un magasin de clés OpenPGP.
			String originalFileName = pgp.decryptFile(path2+fileName,
								path1+privateKeyFile,
								privateKeyPass,
								path2+output);
		} catch (PGPException e) {
			System.out.println("PGPE error :"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error dans les fichiers");
			e.printStackTrace();
		}
	}

}
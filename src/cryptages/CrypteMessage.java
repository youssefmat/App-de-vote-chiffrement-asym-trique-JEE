package cryptages;


import java.io.FileInputStream;
import java.io.InputStream;


import com.didisoft.pgp.PGPLib;
  
public class CrypteMessage {  
	// Constructor
		public CrypteMessage() {
		}
		
		
		public String encrypteMessage(String message, String keyFile) {
			   String encryptedString = "";
			 try {  System.out.println("\n******* encrypte Message ******\n");
				    System.out.println("message est :"+message+"et KeyFile est: "+keyFile);
				 
			        // creer un objet PGPLib
			        PGPLib pgp = new PGPLib();
			 
			        String publicEncryptionKeyFile ="C:/Users/Youssef/eclipse-workspace/app-Vote/Keys/"+keyFile;
			        System.out.println("chemein de fichier + KeyFile : "+publicEncryptionKeyFile);
			      
			        InputStream publicEncryptionKeyStream = null;
						publicEncryptionKeyStream = new FileInputStream(publicEncryptionKeyFile);
			 
			        // encrypte une chaine de caractere passee en argument
						encryptedString = pgp.encryptString(message, publicEncryptionKeyStream);
						System.out.println("encrypte message chaine!!!!!!!!!!!!!!!\n"+encryptedString);
			       } catch (Exception e) {
						System.out.println("error de cryptage !:"+e.getMessage());
						
					}
			             return encryptedString;
		   }
}

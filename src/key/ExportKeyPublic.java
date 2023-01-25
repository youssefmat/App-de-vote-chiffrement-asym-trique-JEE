package key;

import com.didisoft.pgp.KeyStore;


public class ExportKeyPublic {
	public static void main(String[] args) throws Exception{
		// initialiser l'objet keystore		
		KeyStore keyStore = new KeyStore("Keys/pgp.keystore", "changeit");
		boolean asciiArmor = true;
		
		// exporter la cle publique du fichier pgp.keystore			
		keyStore.exportPublicKey("Keys/exported_pub.asc", "", asciiArmor);
		System.out.print("Fin Programme");
	}
}
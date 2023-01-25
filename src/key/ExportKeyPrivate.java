package key;

import com.didisoft.pgp.KeyStore;


public class ExportKeyPrivate {
	public static void main(String[] args) throws Exception{
		// initialiser l'objet keyStore
		KeyStore keyStore = new KeyStore("Keys/pgp.keystore", "changeit");
		boolean asciiArmor = true;
		
		// exporter la cle prive du fichier KeyStore (pgp.keystore)
		keyStore.exportPrivateKey("Keys/exported_sec.asc", "demo2@didisoft.com", asciiArmor);		
		System.out.print("Fin Programme");
	}
}
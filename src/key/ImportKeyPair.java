package key;


import com.didisoft.pgp.KeyStore;


public class ImportKeyPair {
	public static void main(String[] args) throws Exception {
		// initialiser l'objet keyStore
		KeyStore keyStore = new KeyStore("Keys/pgp.keystore", "changeit");
		
		// importer ringKey (private, public, ou les deux) au fichier keyStore
		keyStore.importKeyRing("Keys/private.key");
	}
}
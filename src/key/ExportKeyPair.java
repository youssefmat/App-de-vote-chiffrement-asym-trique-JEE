package key;



import com.didisoft.pgp.KeyStore;


public class ExportKeyPair {
	public static void main(String[] args) throws Exception{
		// Creer un objet Key Store
		KeyStore keyStore = new KeyStore("Keys/pgp.keystore", "changeit");
		//Exporter un cle pair (public e prive) du KeyStore pgp.keystore
		keyStore.exportKeyRing("Keys/keypair.asc", "demo@didisoft.com");
		System.out.print("Fin Programme");
	}
}

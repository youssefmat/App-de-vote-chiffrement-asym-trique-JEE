package key;

import com.didisoft.pgp.KeyStore;


public class ModifieKeyPassword {
	public static void main(String[] args) throws Exception{
		// initialiser l'objet keyStore
		KeyStore ks = new KeyStore("Keys/pgp.keystore", "changeit");
		
		// changer le mot de passe pour le fichier pgp.keystore
		String keyUserId = "demo@didisoft.com";
		String oldPassword = "changeit";
		String newPassword = "985632";
		ks.changePrivateKeyPassword(keyUserId, oldPassword, newPassword);
		System.out.println("Fin Programme");
	}
}

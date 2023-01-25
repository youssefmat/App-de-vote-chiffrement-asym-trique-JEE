package key;

import com.didisoft.pgp.CompressionAlgorithm;
import com.didisoft.pgp.CypherAlgorithm;
import com.didisoft.pgp.HashAlgorithm;
import com.didisoft.pgp.KeyAlgorithm;
import com.didisoft.pgp.KeyPairInformation;
import com.didisoft.pgp.KeyStore;

import java.io.IOException;
import com.didisoft.pgp.*;
import com.didisoft.pgp.exceptions.*;

public class GenerateKeyPairRSA {

	public static void main(String[] args) throws Exception {
		// initialiser l'objet keyStore
		KeyStore ks = new KeyStore("Keys/pgp.keystore", "changeit");
		
		// userId pour la cle generee
		String userId = "youssef.mathouri0@gmail.com";
		
		// algorithmes de hashage
		String[] hashingAlgorithms = new String[]
		                             {HashAlgorithm.SHA1,
									  HashAlgorithm.SHA256,
									  HashAlgorithm.SHA384,
									  HashAlgorithm.SHA512,
									  HashAlgorithm.MD5};
		
		// algorithmes de compression
		String[] compressions = new String[]
		                            {CompressionAlgorithm.ZIP,
									CompressionAlgorithm.ZLIB,
									CompressionAlgorithm.UNCOMPRESSED};
		
		
		String[] cyphers = new String[] {
		                     CypherAlgorithm.CAST5,
							  CypherAlgorithm.AES_128,
							  CypherAlgorithm.AES_192,
							  CypherAlgorithm.AES_256,
							  CypherAlgorithm.TWOFISH};
		
		String privateKeyPassword = "changeit";
		boolean asciiArmor = false;
		int keySizeInBits = 2048;
		try 
		{
		    KeyPairInformation key = 
		 ks.generateKeyPair(keySizeInBits, 
							userId, 
							KeyAlgorithm.RSA, 
							privateKeyPassword, 
							compressions, 
							hashingAlgorithms, 
							cyphers);
		    
		    KeyPairInformation.SubKey[] subKeys = key.getPrivateSubKeys();
		    System.out.println(subKeys);
		    try {
			    ks.exportPrivateKey("Keys/privatekeyde.key", "youssef.mathouri0@gmail.com", asciiArmor);
			    ks.exportPublicKey("Keys/publickeyde.key", "youssef.mathouri0@gmail.com", asciiArmor);
		      } catch (NoPrivateKeyFoundException e) {
		        System.out.println("There is no private key in the KeyStore with " +
		                           "the specified User ID :!!!!!");
		      } catch (IOException e) {
		        System.out.println(e.getMessage());
		      }
		} 
		catch (com.didisoft.pgp.PGPException e) 
		{
		    System.out.println(e.getMessage());
		    if (e.getUnderlyingException() != null) {
		        e.getUnderlyingException().printStackTrace();
		    }
		}
	}
}

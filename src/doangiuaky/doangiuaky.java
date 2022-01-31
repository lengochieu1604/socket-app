package doangiuaky;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class doangiuaky {
  public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    String SECRET_KEY = "1234567891111111";
    SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
    
    String original = "stackjava.dfjhkjfdkgjcom";
    
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    byte[] byteEncrypted = cipher.doFinal(original.getBytes());
    String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
    
    
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
    String decrypted = new String(byteDecrypted);
    
    System.out.println("original  text: " + original);
    System.out.println("encrypted text: " + encrypted);
    System.out.println("decrypted text: " + decrypted);
    
  }
}
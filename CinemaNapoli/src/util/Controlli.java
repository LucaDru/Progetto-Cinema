package util;

import java.security.SecureRandom;

public class Controlli {
     
     
     public static String generaBiglietto( ) {
    	 String lower = "abcdefghijklmnopqrstuvwxyz";
         String upper = lower.toUpperCase();
         String numeri = "0123456789";
         String perRandom = upper + lower + numeri;
         int lunghezzaRandom = 9;
         
	     SecureRandom sr = new SecureRandom();
	     StringBuilder sb = new StringBuilder(lunghezzaRandom);
	     for (int i = 0; i < lunghezzaRandom; i++) {
	         int randomInt = sr.nextInt(perRandom.length());
	         char randomChar = perRandom.charAt(randomInt);
	         sb.append(randomChar);
	     }
	     return sb.toString();
     }
     
     public static String controlloInserimento(String inserimento) {		
 		//String inserimento = null;
 		String converti = inserimento.substring(0,1).toUpperCase() + inserimento.substring(1).toLowerCase();
 		return converti;
 	}
     
     public static String resetPassword( ) {
    	 String lower = "abcdefghijklmnopqrstuvwxyz";
         String upper = lower.toUpperCase();
         String numeri = "0123456789";
         String perRandom = upper + lower + numeri;
         int lunghezzaRandom = 7;
         
	     SecureRandom sr = new SecureRandom();
	     StringBuilder sb = new StringBuilder(lunghezzaRandom);
	     for (int i = 0; i < lunghezzaRandom; i++) {
	         int randomInt = sr.nextInt(perRandom.length());
	         char randomChar = perRandom.charAt(randomInt);
	         sb.append(randomChar);
	     }
	     return sb.toString();
     }


}

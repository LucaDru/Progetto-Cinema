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
     
     //String converti = inserimento.substring(0,1).toUpperCase() + inserimento.substring(1).toLowerCase().trim();
     public static boolean controlloInserimento(String inserimento) {
    	 System.out.println("nomi");
    	 if(inserimento == null) {
     		return false;
     	}
 		return inserimento.toLowerCase().trim().matches("[a-z]*");
 	}
     
     public static boolean controlloCap (String cap) {
    	 if(cap == null) {
     		return false;
     	}
    	 System.out.println("cap");
    	 return cap.trim().matches("[0-9]{5}");
     }
     
     public static boolean controlloNumeri (String num) {
    	 if(num == null) {
     		return false;
     	}
    	 System.out.println("numeri");
    	 return num.trim().matches("[0-9]");
     }
     
     public static boolean controlloCf (String cf) {
    	 System.out.println("cf");
    	 if(cf == null) {
     		return false;
     	}
    	 return cf.toUpperCase().trim().matches("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$");
     }
     
     public static boolean controlloEmail (String em) {
    	 System.out.println("email");
    	 if(em == null) {
     		return false;
     	}
    	 return em.toLowerCase().trim().matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}");
     }
     
     public static boolean controlloVuoto(String s) {
    	 if(s == null) {
     		return false;
     	}
    	 return !(s.trim().equals(""));
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

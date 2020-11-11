package util;

import model.User;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class InvioEmail {
	
	private static String msgConferma="Il tuo account è stato confermato, adesso puoi effettuare il login.";
	private static String msgDefault="Questo è un messaggio autogenerato.";
	private static String msgReset="La tua password è stata resettata.";
	private static String msgPrenotazione="La tua prenotazione è andata a buon fine.";
	private static String msgAnnullaPre="La tua prenotazione è stata annullata.";
	private static String msgDisattivazione="Il tuo account è stato disattivato."
			+ "Se desideri riattivarlo contatta l'admin: multisalamedea@gmail.com";
	
	
	//---
	private static String scegliMessaggio(String scelta) {
		
		switch(scelta) {
			case "conferma":
				return msgConferma;
			case "reset":
				return msgReset;
			case "prenotazione":
				return msgPrenotazione;
			case "annulla":
				return msgAnnullaPre;
			case "disattivazione":
				return msgDisattivazione;
				
		}
		return msgDefault;
	}
	//---
	public static void mandaMail(User u,String scelta) {
		
		String to = u.getEmail();
	    String subject = scelta;
	    String msg = scegliMessaggio(scelta);
	    String from ="multisalamedea@gmail.com";
	    String password ="medeamedea";


	    Properties props = new Properties();
	    props.setProperty("mail.transport.protocol", "smtp");
	    props.setProperty("mail.host", "smtp.gmail.com");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	    props.put("mail.debug", "true");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");
	    Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(from,password);  
	   }  
	   });  

	   //session.setDebug(true);  
	   try {
		   Transport transport = session.getTransport();
		   InternetAddress addressFrom = new InternetAddress(from);

		   MimeMessage message = new MimeMessage(session);
		   message.setSender(addressFrom);
		   message.setSubject(subject);
		   message.setContent(msg, "text/plain");
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		   transport.connect();
		   Transport.send(message);
		   transport.close();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	}
}

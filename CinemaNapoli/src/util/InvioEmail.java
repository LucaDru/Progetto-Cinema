package util;

import model.Prenotazione;
import model.User;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class InvioEmail {
	
	private static String msgConferma="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "<title>Conferma</title><style>*{ box-sizing: border-box;}</style></head><body><div class=\"container\">\r\n"
			+ "<div style=\"background-color: #2c031e; height: 500px; width: 500px; padding: 6%;\"><div style=\"background-color: white; width: 100%; height:100%; padding: 15%; padding-top: 35%;\">\r\n"
			+ "<span>Il tuo account è stato confermato.</span></br><span>Adesso puoi effettuare il login.</span></div></div></div></body></html>";
	private static String msgDefault="Questo è un messaggio autogenerato.";
	private static String msgReset="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "<title>Conferma</title><style>*{ box-sizing: border-box;}</style></head><body><div class=\"container\">\r\n"
			+ "<div style=\"background-color: #2c031e; height: 500px; width: 500px; padding: 6%;\"><div style=\"background-color: white; width: 100%; height:100%; padding: 15%; padding-top: 35%;\">\r\n"
			+ "<span>La tua password è stata resettata.</span></br><span>La nuova password è :</span></br></br><span>";
	private static String msgReset2="</span></div></div></div></body></html>";
	private static String msgPrenotazione="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "<title>Conferma</title></head><body><div class=\"container\"><div style=\"background-color: #2c031e; height: 500px; width: 500px; padding: 6%;\">\r\n"
			+ "<div style=\"background-color: white; width: 100%; height:100%; padding: 15%; padding-top: 35%;\">\r\n"
			+ "<span>La tua prenotazione è andata a buon fine.</span></br><span>Il tuo biglietto &egrave; stato inviato in allegato</span></br></br><span class=\"bar\"><img url='cid:qrCode'/>";
	private static String msgPrenotazione2="</span></div></div></div></body></html>";
	private static String msgAnnullaPre1="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "<title>Conferma</title><style>* {box-sizing: border-box;}\r\n"
			+ "</style></head><body><div class=\"container\"><div style=\"background-color: #2c031e; height: 500px; width: 500px; padding: 6%;\">\r\n"
			+ "<div style=\"background-color: white; width: 100%; height:100%; padding: 15%; padding-top: 35%;\">\r\n"
			+ "<span>La tua prenotazione con codice :</span></br><span>";
	private static String msgAnnullaPre2="</span></br><span>è stata annullata.</span></br></br></div></div></div></body></html>";
	private static String msgDisattivazione="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			+ "<title>Conferma</title><style>* {box-sizing: border-box;}\r\n"
			+ "</style></head><body><div class=\"container\"><div style=\"background-color: #2c031e; height: 500px; width: 500px; padding: 6%;\">\r\n"
			+ "<div style=\"background-color: white; width: 100%; height:100%; padding: 15%; padding-top: 35%;\">\r\n"
			+ "<span>Il tuo account è stato disattivato</span></br><span>Se desideri riattivarlo contatta l'admin: multisalamedea@gmail.com</span></br></br></div></div></div></body></html>";
	
	
	//---
	private static String scegliMessaggio(String scelta,String pwd) {
		
		switch(scelta) {
			case "conferma":
				return msgConferma;
			case "reset":
				String msg=msgReset+pwd+msgReset2;
				return msg;
			case "prenotazione":
				//c4bLYXS
				return msgPrenotazione+pwd+msgPrenotazione2;
			case "annulla":
				return msgAnnullaPre1+pwd+msgAnnullaPre2;
			case "disattivazione":
				return msgDisattivazione;
				
		}
		return msgDefault;
	}
	//---
	public static void mandaMail(User u,String scelta,String pwd) {
		
		String to = u.getEmail();
	    String subject = scelta;
	    String msg = scegliMessaggio(scelta,pwd);
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
		   message.setContent(msg, "text/html");
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		   transport.connect();
		   Transport.send(message);
		   transport.close();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	}
	
public static void mandaMailBiglietto(User u,String scelta,Prenotazione p) {
		
		String to = u.getEmail();
	    String subject = scelta;
	    String msg = scegliMessaggio(scelta,p.getBiglietto());
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
		   //message.setContent(msg, "text/html");
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		   MimeBodyPart bodyHtmlPart = new MimeBodyPart();

	         // Now set the actual message
	         //bodyHtmlPart.setText(msg,"text/html; charset=utf-8");
	         bodyHtmlPart.setContent(msg,"text/html; charset=utf-8");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(bodyHtmlPart);
	         MimeBodyPart imgBodyPart = new MimeBodyPart();
	         // Part two is attachment
	         imgBodyPart = new MimeBodyPart();
	         String filename = "D:\\Git-Repo\\Progetto-Cinema\\CinemaNapoli\\WebContent\\caroImg\\biglietti\\"+p.getBiglietto()+".png";
	         DataSource source = new FileDataSource(filename);
	         imgBodyPart.setDataHandler(new DataHandler(source));
	         imgBodyPart.setFileName(filename);
	         multipart.addBodyPart(imgBodyPart);

	         // Send the complete message parts
	         
	         //MimeBodyPart imgHtmlPart = new MimeBodyPart();
	         //imgHtmlPart.setDataHandler(new DataHandler(source));
	         //imgHtmlPart.setHeader("Content-ID", "<qrCode>");
	         //multipart.addBodyPart(imgHtmlPart);
	         message.setContent(multipart);
	         
		   transport.connect();
		   Transport.send(message);
		   transport.close();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	}
}

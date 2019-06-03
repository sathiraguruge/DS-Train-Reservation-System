package emailservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	private final String companyEmailUsername = "reservationtrain880@gmail.com";
	private final String companyEmailPassword = "Test123#";
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private final String subject = "Sri Lanka Train Reservation System#";

	public Email() {
		
	}
	
	public boolean sendMail(String recipientEmail, String ticketCount, String train, String trainName, String total) {
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();  
			   String today = dtf.format(now);
			   
			String uniqueID = UUID.randomUUID().toString();
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(companyEmailUsername, companyEmailPassword);
				}
			});
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(companyEmailUsername));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));
			msg.setSubject(subject);
			msg.setText("You have sucessfully Booked " + ticketCount + " tickets in \n" +
						"Train				: " + train + "\n" +
						"Train Name 		: " + trainName + "\n" +
						"Purchase made on 	: " + today + "\n" +
						"Total 				: " + total + "\n" + 
						"Booking Reference 	: " + uniqueID + "\n" + 
						"Please provide your booking reference at the Railway Station"
						);
			msg.setSentDate(new Date());
			Transport.send(msg);
			System.out.println("Message sent.");
			return true;
		} catch (MessagingException e) {
			System.out.println("Message Sending Failed: " + e);
			return false;
		}
			
	}
}

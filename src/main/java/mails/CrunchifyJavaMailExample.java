package mails;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CrunchifyJavaMailExample {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail();
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}

	public static void generateAndSendEmail() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress("nguyen.van.manh@vsi-international.com"));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("manh.1403@cokhituean.com"));
		generateMailMessage.setSubject("Greetings from Crunchify..");
		String emailBody = "Test email by Crunchify.com JavaMail API example. "
				+ "<br><br> Regards, <br>Crunchify Admin";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password (XXXarpitshah@gmail.com)
		transport.connect("smtp.gmail.com", "<-- your gmail USERNAME -->", "<-- your gmail PASSWORD -->");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	// Output:
	// 1st ===> setup Mail Server Properties..
	// Mail Server Properties have been setup successfully..
	//
	// 2nd ===> get Mail Session..
	// Mail Session has been created successfully..
	//
	// 3rd ===> Get Session and Send mail
	// ===> Your Java Program has just sent an Email successfully. Check your email..
}

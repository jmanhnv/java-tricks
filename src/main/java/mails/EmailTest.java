package mails;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailTest {
	private static void simpleEmail() {
		System.out.println("SimpleEmail Start");

		String smtpHostServer = "smtp.example.com";
		String emailID = "email_me@example.com";

		Properties props = System.getProperties();

		props.put("mail.smtp.host", smtpHostServer);

		Session session = Session.getInstance(props, null);

		EmailUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use authentication) Use Authentication: Yes Port
	 * for TLS/STARTTLS: 587
	 */
	private static void tlsEmail() {
		final String fromEmail = "myemailid@gmail.com"; // requires valid gmail id
		final String password = "mypassword"; // correct password for gmail id
		final String toEmail = "myemail@yahoo.com"; // can be any email id

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		EmailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject", "TLSEmail Testing Body");
	}

	/**
	 * Outgoing Mail (SMTP) Server requires TLS or SSL: smtp.gmail.com (use authentication) Use Authentication: Yes Port
	 * for SSL: 465
	 */
	private static void sslEmail() {
		final String fromEmail = "myemailid@gmail.com"; // requires valid gmail id
		final String password = "mypassword"; // correct password for gmail id
		final String toEmail = "myemail@yahoo.com"; // can be any email id

		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.socketFactory.port", "465"); // SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true"); // Enabling SMTP Authentication
		props.put("mail.smtp.port", "465"); // SMTP Port

		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
		EmailUtil.sendEmail(session, toEmail, "SSLEmail Testing Subject", "SSLEmail Testing Body");

		EmailUtil.sendAttachmentEmail(session, toEmail, "SSLEmail Testing Subject with Attachment",
				"SSLEmail Testing Body with Attachment");

		EmailUtil.sendImageEmail(session, toEmail, "SSLEmail Testing Subject with Image",
				"SSLEmail Testing Body with Image");
	}

	public static void main(String[] args) {
		simpleEmail();
		tlsEmail();
		sslEmail();
	}

}

package mails;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Send a Simple E-mail.
 * 
 * @see http://www.tutorialspoint.com/java/java_sending_email.htm
 */
public class SendMail {
	private static final String CONTENT_TYPE = "text/plain";

	// Setup mail server
	private static final String SMTP_HOST_NAME = "103.15.48.243";
	private static final String SMTP_AUTH_USER = "manh.1403@cokhituean.com";
	private static final String SMTP_AUTH_PWD = "W3lc0me!";

	/**
	 * <p>
	 * Send a Simple E-mail.
	 * </p>
	 * 
	 * @param args
	 *            the default arguments
	 **/
	public static void main(String[] args) {
		try {
			send();
			System.out.println("Your mail sent successfully....");
		} catch (Exception e) {
			System.err.println("Send mail failure: " + e.getCause());
		}
	}

	private static void send() throws Exception {
		// Get system properties
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");

		Authenticator auth = new SMTPAuthenticator();

		// Get the default Session object.
		Session mailSession = Session.getDefaultInstance(props, auth);
		Transport transport = mailSession.getTransport();

		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(mailSession);

		String subject = "Email Expiry Notification";
		String msg = "This is an e-mail message sent automatically by system administration.";

		// Sender's email ID needs to be mentioned
		String from = "noreply@webadmin.com";

		// Recipient's email ID needs to be mentioned.
		Address[] recipients = { new InternetAddress("nguyen.van.manh@vsi-international.com"),
				new InternetAddress("manh.1403@gmail.com") };

		// Set From: header field of the header.
		message.setFrom(new InternetAddress(from));

		// Set To: header field of the header.
		// message.addRecipient(Message.RecipientType.TO, new InternetAddress("nguyen.van.manh@vsi-international.com"));
		message.addRecipients(Message.RecipientType.TO, recipients);

		// Set Subject: header field
		message.setSubject(subject, CONTENT_TYPE);

		// Now set the actual message
		message.setContent(msg, CONTENT_TYPE);

		// Send message within actual HTML message
		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	/**
	 * @see {@link Authenticator}
	 **/
	private static class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
		}
	}
}

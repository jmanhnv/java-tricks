///*
// * FILENAME SendFileEmail.java FILE LOCATION $Source$ VERSION $Id$
// * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
// * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
// * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
// * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
// * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
// */
//
//package mails;
//
//import java.util.Properties;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
////
//// IMPORTS
//// NOTE: Import specific classes without using wildcards.
////
//
///**
// * Send Attachment in E-mail.
// * 
// * @see http://www.tutorialspoint.com/java/java_sending_email.htm
// */
//public class SendFileEmail {
//	public static void main(String[] args) {
//		// Recipient's email ID needs to be mentioned.
//		String to = "abcd@gmail.com";
//
//		// Sender's email ID needs to be mentioned
//		String from = "web@gmail.com";
//
//		// Assuming you are sending email from localhost
//		String host = "localhost";
//
//		// Get system properties
//		Properties properties = System.getProperties();
//
//		// Setup mail server
//		properties.setProperty("mail.smtp.host", host);
//
//		// Get the default Session object.
//		Session session = Session.getDefaultInstance(properties);
//
//		try {
//			// Create a default MimeMessage object.
//			MimeMessage message = new MimeMessage(session);
//
//			// Set From: header field of the header.
//			message.setFrom(new InternetAddress(from));
//
//			// Set To: header field of the header.
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//			// Set Subject: header field
//			message.setSubject("This is the Subject Line!");
//
//			// Create the message part
//			BodyPart messageBodyPart = new MimeBodyPart();
//
//			// Fill the message
//			messageBodyPart.setText("This is message body");
//
//			// Create a multipar message
//			Multipart multipart = new MimeMultipart();
//
//			// Set text message part
//			multipart.addBodyPart(messageBodyPart);
//
//			// Part two is attachment
//			messageBodyPart = new MimeBodyPart();
//			String filename = "file.txt";
//			DataSource source = new FileDataSource(filename);
//			messageBodyPart.setDataHandler(new DataHandler(source));
//			messageBodyPart.setFileName(filename);
//			multipart.addBodyPart(messageBodyPart);
//
//			// Send the complete message parts
//			message.setContent(multipart);
//
//			// Send message
//			Transport.send(message);
//			System.out.println("Sent message successfully....");
//		} catch (MessagingException mex) {
//			mex.printStackTrace();
//		}
//	}
//}
